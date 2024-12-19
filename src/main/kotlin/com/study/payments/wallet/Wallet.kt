package com.study.payments.wallet

import com.fasterxml.jackson.annotation.JsonBackReference
import com.study.payments.consumer.Consumer
import com.study.payments.seller.Seller
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.math.BigDecimal

@Entity
@Table(name = "wallets")
data class Wallet (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column(nullable = false, precision = 15, scale = 2)
    val balance: BigDecimal = BigDecimal.ZERO,

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "seller_id", referencedColumnName = "id", unique = true)
    val seller: Seller? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "consumer_id", referencedColumnName = "id", unique = true)
    val consumer: Consumer? = null,
) {
    companion object {
        fun toResponseDto(wallet: Wallet) = WalletResponseDto(
            id = wallet.id!!,
            balance = wallet.balance
        )
    }
}
