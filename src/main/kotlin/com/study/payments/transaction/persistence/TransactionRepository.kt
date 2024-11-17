package com.study.payments.transaction.persistence

import com.study.payments.transaction.core.Transaction

interface TransactionRepository {
    fun save(transaction: Transaction): Transaction
}
