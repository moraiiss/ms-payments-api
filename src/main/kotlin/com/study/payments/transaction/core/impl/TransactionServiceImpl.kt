package com.study.payments.transaction.core.impl

import com.study.payments.transaction.core.Transaction
import com.study.payments.transaction.core.TransactionService
import com.study.payments.transaction.persistence.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl (
    private val repository: TransactionRepository
) : TransactionService {
    override fun createTransaction(transaction: Transaction): Transaction {
        return repository.save(transaction)
    }
}
