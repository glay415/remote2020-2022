package com.example.mitalk.domain.record.presentation

import com.example.mitalk.domain.record.presentation.data.response.GetRecordDetailResponse
import com.example.mitalk.domain.record.presentation.data.response.GetRecordResponse
import com.example.mitalk.domain.record.domain.repository.RecordRepository
import com.example.mitalk.domain.record.service.GetRecordDetailService
import com.example.mitalk.domain.record.service.GetRecordService
import com.example.mitalk.global.util.UserUtil
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class RecordController(
    private val getRecordService: GetRecordService,
    private val getRecordDetailService: GetRecordDetailService,
    private val userUtil: UserUtil,
    private val recordRepository: RecordRepository
) {

    @Transactional(readOnly = true)
    @GetMapping("/customer/record")
    fun getRecordByCustomer(): GetRecordResponse {
        val customerId = userUtil.getCurrentCustomer().id
        val record = recordRepository.findByCustomerId(customerId)
        return getRecordService.execute(record)
    }

    @Transactional(readOnly = true)
    @GetMapping("/counsellor/record")
    fun getRecordByCounsellor(): GetRecordResponse {
        val counsellorId = userUtil.getCurrentCounsellor().id
        val record = recordRepository.findByCounsellorId(counsellorId)
        return getRecordService.execute(record)
    }

    @GetMapping("/record/{record-id}")
    fun getRecordDetails(@PathVariable("record-id") recordId: UUID): GetRecordDetailResponse {
        return getRecordDetailService.execute(recordId)
    }
}