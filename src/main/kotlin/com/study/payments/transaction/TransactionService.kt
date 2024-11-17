package com.study.payments.transaction

import java.math.BigDecimal

interface TransactionService {
    fun executeTransfer(payerId: Long, payeeId: Long, amount: BigDecimal): Transaction
}
