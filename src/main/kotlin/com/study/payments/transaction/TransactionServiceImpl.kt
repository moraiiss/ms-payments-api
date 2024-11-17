package com.study.payments.transaction

import com.study.payments.wallet.WalletRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TransactionServiceImpl (
    private val walletRepository: WalletRepository,
    private val transactionRepository: TransactionRepository
) : TransactionService {
    override fun executeTransfer(payerId: Long, payeeId: Long, amount: BigDecimal): Transaction {
        val payer = walletRepository.findById(payerId)
        val payee = walletRepository.findById(payeeId)

        if (!walletRepository.isConsumerWallet(payerId)) {
            throw IllegalArgumentException("Payer must be a consumer")
        }

        val transaction = Transaction(
            payee = payee,
            payer = payer,
            amount = amount
        )

        return try {
            val processedTransaction = transaction.process()
            walletRepository.save(processedTransaction.payer)
            walletRepository.save(processedTransaction.payee)
            transactionRepository.save(processedTransaction)
        } catch (e: IllegalArgumentException) {
            transactionRepository.save(transaction.failed())
            throw e
        }

    }
}
