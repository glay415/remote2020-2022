package com.example.mitalk.global.security.auth

import com.example.mitalk.domain.counsellor.domain.repository.CounsellorRepository
import com.example.mitalk.domain.counsellor.exception.CounsellorNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class CounsellorDetailService(
        private val counsellorRepository: CounsellorRepository
) : UserDetailsService {
    override fun loadUserByUsername(uuid: String): UserDetails {
        val counsellor = counsellorRepository.findByIdOrNull(UUID.fromString(uuid)) ?: throw CounsellorNotFoundException()
        return CounsellorDetails(counsellor)
    }
}