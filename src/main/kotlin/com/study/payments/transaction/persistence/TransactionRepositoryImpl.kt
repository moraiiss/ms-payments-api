package com.study.payments.transaction.persistence

import com.study.payments.transaction.core.Transaction
import org.springframework.stereotype.Component

@Component
class TransactionRepositoryImpl (
    private val springTransactionRepository: SpringTransactionRepository
) : TransactionRepository {
    override fun save(transaction: Transaction): Transaction {
        val savedTransaction: TransactionEntity = springTransactionRepository
            .save(TransactionEntity.fromTransaction(transaction))

        return TransactionEntity
            .toTransaction(savedTransaction)
    }
}
