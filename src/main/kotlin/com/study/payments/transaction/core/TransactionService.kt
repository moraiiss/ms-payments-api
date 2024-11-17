package com.study.payments.transaction.core

interface TransactionService {
    fun createTransaction(transaction: Transaction): Transaction
}
