package com.study.payments.consumer

import com.study.payments.wallet.Wallet
import com.study.payments.wallet.WalletEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.CascadeType

@Entity
@Table(name = "consumers")
class ConsumerEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,

    @OneToOne(mappedBy = "consumer", cascade = [CascadeType.ALL], optional = false)
    val wallet: WalletEntity? = null
)
