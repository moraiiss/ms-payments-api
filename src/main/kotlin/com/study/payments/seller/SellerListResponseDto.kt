package com.study.payments.seller

import java.time.LocalDateTime

data class SellerListResponseDto(
    val id: String?,
    val name: String,
    val email: String,
    val document: String,
    val createdAt: LocalDateTime,
)
