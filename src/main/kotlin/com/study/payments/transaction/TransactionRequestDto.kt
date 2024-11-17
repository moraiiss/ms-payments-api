package com.study.payments.transaction

import java.math.BigDecimal

data class TransactionRequestDto(
    val payee: Long,
    val payer: Long,
    val amount: BigDecimal
)
