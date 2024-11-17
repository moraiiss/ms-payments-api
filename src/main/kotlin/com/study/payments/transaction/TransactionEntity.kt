package com.study.payments.transaction

import com.study.payments.wallet.WalletEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Column
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transactions")
class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
    val payer: WalletEntity,

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
    val payee: WalletEntity,

    @Column(nullable = false)
    val amount: BigDecimal,

    val status: String = TransactionStatusEnum.PENDING.name,

    val transactionDate: LocalDateTime = LocalDateTime.now()
)
