package com.example.mitalk.domain.admin.service

import com.example.mitalk.domain.admin.presentation.data.response.GetRecordListRequest
import com.example.mitalk.domain.record.domain.repository.RecordRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetRecordListService(
    private val recordRepository: RecordRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): List<GetRecordListRequest> {
        return recordRepository.findAll().map {
            GetRecordListRequest(
                id = it.id,
                startAt = it.startAt,
                counsellorName = it.counsellorName,
                customerName = it.customerName,
                type = it.counsellingType
            )
        }
    }
}