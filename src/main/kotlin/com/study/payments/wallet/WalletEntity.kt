package com.study.payments.wallet

import com.study.payments.consumer.ConsumerEntity
import com.study.payments.seller.SellerEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Column
import java.math.BigDecimal

@Entity
@Table(name = "wallets")
data class WalletEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "consumer_id", unique = true)
    val consumer: ConsumerEntity? = null,

    @OneToOne
    @JoinColumn(name = "seller_id", unique = true)
    val seller: SellerEntity? = null,

    @Column(nullable = false)
    val balance: BigDecimal = BigDecimal.ZERO
)
