package com.study.payments.transaction

import com.study.payments.wallet.Wallet
import com.study.payments.wallet.WalletEntity
import com.study.payments.wallet.WalletRepository
import org.springframework.stereotype.Component

@Component
class TransactionRepositoryImpl (
    private val repository: SpringTransactionRepository,
    private val walletRepository: WalletRepository
) : TransactionRepository {
    override fun save(transaction: Transaction): Transaction {
        val payeeWallet = walletRepository.findById(transaction.payee.id!!)
        val payerWallet = walletRepository.findById(transaction.payer.id!!)

        val entity = TransactionEntity(
            id = transaction.id,
            payee = WalletEntity(
                id = payeeWallet.id,
                balance = payeeWallet.balance
            ),
            payer = WalletEntity(
                id = payerWallet.id,
                balance = payerWallet.balance
            ),
            amount = transaction.amount
        )

        val savedTransaction = repository.save(entity)

        return Transaction(
            id = savedTransaction.id,
            payee = Wallet(
                id = savedTransaction.payee.id,
                balance = savedTransaction.payee.balance
            ),
            payer = Wallet(
                id = savedTransaction.payer.id,
                balance = savedTransaction.payer.balance
            ),
            amount = savedTransaction.amount
        )
    }

    override fun findById(id: Long): Transaction? {
        val entity = repository
            .findById(id)
            .orElse(null)

        return if (entity != null) {
            Transaction(
                id = entity.id,
                payee = Wallet(
                    id = entity.payee.id,
                    balance = entity.payee.balance
                ),
                payer = Wallet(
                    id = entity.payer.id,
                    balance = entity.payer.balance
                ),
                amount = entity.amount
            )
        } else {
            null
        }
    }
}
