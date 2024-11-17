package com.study.payments.transaction.application

import java.math.BigDecimal

data class TransactionRequestDto(
    val payee: Long,
    val payer: Long,
    val value: BigDecimal
)
