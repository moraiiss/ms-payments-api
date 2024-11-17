package com.study.payments.transaction.persistence

import com.study.payments.transaction.core.Transaction
import com.study.payments.transaction.core.TransactionStatusEnum
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transactions")
class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val payee: Long,
    val payer: Long,
    val value: BigDecimal,
    val status: String = TransactionStatusEnum.PENDING.name,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun fromTransaction(transaction: Transaction) = TransactionEntity(
            payee = transaction.payee,
            payer = transaction.payer,
            value = transaction.value
        )

        fun toTransaction(transactionEntity: TransactionEntity) = Transaction(
            id = transactionEntity.id,
            payee = transactionEntity.payee,
            payer = transactionEntity.payer,
            value = transactionEntity.value,
            status = transactionEntity.status,
            createdAt = transactionEntity.createdAt.toString()
        )
    }
}
