package com.study.payments.transaction

interface TransactionRepository {
    fun save(transaction: Transaction): Transaction
    fun findById(id: Long): Transaction?
}
