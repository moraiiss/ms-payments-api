package com.study.payments.wallet

import org.springframework.stereotype.Component

@Component
class WalletRepositoryImpl(
    private val repository: SpringWalletRepository
): WalletRepository {
    override fun findById(id: Long): Wallet {
        val entity = repository
            .findById(id)
            .orElse(null)

        return Wallet(
            id = entity.id,
            balance = entity.balance
        )
    }

    override fun save(wallet: Wallet): Wallet {
        val entity = WalletEntity(
            id = wallet.id,
            balance = wallet.balance
        )

        val savedWallet = repository.save(entity)

        return Wallet(
            id = savedWallet.id,
            balance = savedWallet.balance
        )
    }

    override fun isConsumerWallet(walletId: Long): Boolean {
        return repository.existsById(walletId)
    }
}
