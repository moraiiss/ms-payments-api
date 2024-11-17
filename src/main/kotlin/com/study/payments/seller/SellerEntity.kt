package com.study.payments.seller

import com.study.payments.wallet.Wallet
import com.study.payments.wallet.WalletEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.OneToOne

@Entity
@Table(name = "sellers")
class SellerEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,

    @OneToOne(mappedBy = "seller", cascade = [CascadeType.ALL], optional = false)
    val wallet: WalletEntity? = null
)
