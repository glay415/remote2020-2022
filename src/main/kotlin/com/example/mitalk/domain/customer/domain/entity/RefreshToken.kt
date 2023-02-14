package com.example.mitalk.domain.customer.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import java.util.*

@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
class RefreshToken(
        @Id
        @Indexed
        val userId: UUID? = null,
        @Indexed
        val token: String,
)