package com.example.mitalk.domain.customer.presentation.data.response

import java.util.UUID

class CurrentStatusResponse(
        val needReview: UUID?,
        val counsellorName: String?,
        val roomId: UUID?
) {
}