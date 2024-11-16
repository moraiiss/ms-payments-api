package com.study.payments.persistence.entity

import com.study.payments.domain.TransactionStatusEnum
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transactions")
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val payee: Long,
    val payer: Long,
    val value: BigDecimal,
    val status: TransactionStatusEnum = TransactionStatusEnum.PENDING,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
