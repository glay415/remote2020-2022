package com.example.mitalk.domain.customer.domain.repository

import com.example.mitalk.domain.admin.presentation.data.response.StatisticReviewElement
import com.example.mitalk.domain.customer.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal
import java.util.UUID
import javax.persistence.Tuple

interface ReviewRepository : JpaRepository<Review, Long> {

    @Query(value = "select COALESCE(AVG(rv.star),0) from Review rv")
    fun getAllStar(): BigDecimal

    @Query(value = "select COALESCE(AVG(rv.star),0) from Review rv where rv.counsellor = :counsellor_id")
    fun getStarByCounsellorId(@Param("counsellor_id") counsellorId: UUID): BigDecimal

    @Query(value =
    "select " +
            "re.review_item, " +
            "count(*) / (select count(*) from review_element) * 100 as percentage " +
            "from review rv " +
            "left join review_element re " +
            "on rv.id = re.review_id " +
            "group by re.review_item",
        nativeQuery = true)
    fun getAllReviews(): List<Tuple>

    @Query(value =
    "select " +
            "re.review_item, " +
            "count(*) / (select count(*) from review_element) * 100 as percentage " +
            "from review rv " +
            "left join review_element re " +
            "on rv.id = re.review_id " +
            "where rv.counsellor = :counsellor_id " +
            "group by re.review_item",
        nativeQuery = true)
    fun getReviewByCounsellorId(@Param("counsellor_id") counsellorId: UUID): List<Tuple>

    fun findByCounsellor(counsellor: UUID): List<Review>
}