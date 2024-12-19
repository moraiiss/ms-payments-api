package com.study.payments.exceptions

import java.time.LocalDateTime

data class ExceptionResponseDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
