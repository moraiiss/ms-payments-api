package com.study.payments.consumer

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.study.payments.wallet.Wallet
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "sellers")
class Consumer(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,

    @Column(nullable = false, unique = true, length = 100)
    val name: String,

    @Column(nullable = false, unique = true, length = 100)
    val email: String,

    @Column(nullable = false, unique = true)
    val document: String,

    @OneToOne(mappedBy = "consumer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonManagedReference
    val wallet: Wallet,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
