package com.study.payments.wallet

import java.math.BigDecimal

data class Wallet (
    val id: Long?,
    val balance: BigDecimal,
) {
    fun debit(value: BigDecimal): Wallet {
        if (balance < value) {
            throw IllegalArgumentException("Insufficient balance")
        }
        return this.copy(balance = balance.subtract(value))
    }

    fun credit(value: BigDecimal): Wallet {
        return this.copy(balance = balance.add(value))
    }
}
