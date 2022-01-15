package com.highthon.school.domain.interest.repository;

import com.highthon.school.domain.interest.Interest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InterestRepository extends CrudRepository<Interest, Integer> {
    Optional<Interest> findByJab_NameAndUser_Id(String jab, String userId);
}
