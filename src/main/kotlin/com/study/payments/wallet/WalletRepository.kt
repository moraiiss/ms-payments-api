package com.study.payments.wallet

interface WalletRepository {
    fun findById(id: Long): Wallet
    fun save(wallet: Wallet): Wallet
    fun isConsumerWallet(walletId: Long): Boolean
}
