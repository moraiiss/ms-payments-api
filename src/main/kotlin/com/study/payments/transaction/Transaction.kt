package com.study.payments.transaction

import com.study.payments.wallet.Wallet
import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val id: Long? = null,
    val payee: Wallet,
    val payer: Wallet,
    val amount: BigDecimal,
    val status: TransactionStatusEnum = TransactionStatusEnum.PENDING,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    fun process(): Transaction {

        if (amount <= BigDecimal.ZERO) {
            throw IllegalArgumentException("Amount must be greater than zero")
        }

        if (payer.id == payee.id) {
            throw IllegalArgumentException("Payer and payee must be different")
        }

        val payeeDebited = payee.debit(amount)
        val payerCredited = payer.credit(amount)

        return this.copy(
            status = TransactionStatusEnum.COMPLETED,
            payee = payeeDebited,
            payer = payerCredited,
        )
    }

    fun failed(): Transaction {
        return this.copy(status = TransactionStatusEnum.REJECTED)
    }
}
