package com.study.payments.transaction.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.study.payments.transaction.application.TransactionRequestDto
import java.math.BigDecimal

@JsonInclude(Include.NON_NULL)
class Transaction(
    val id: Long? = null,
    val payee: Long,
    val payer: Long,
    val value: BigDecimal,
    val status: String? = null,
    val createdAt: String? = null
) {
    companion object {
        fun fromTransactionDto(transaction: TransactionRequestDto) = Transaction (
            payee = transaction.payee,
            payer = transaction.payer,
            value = transaction.value,
        )
    }
}
