package com.study.payments.seller

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
class Seller(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column(nullable = false, unique = true, length = 100)
    val name: String,

    @Column(nullable = false, unique = true, length = 100)
    val email: String,

    @Column(nullable = false, unique = true)
    val document: String,

    @JsonManagedReference
    @OneToOne(mappedBy = "seller", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val wallet: Wallet,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun toListResponseDto(seller: Seller) = SellerListResponseDto(
            id = seller.id,
            name = seller.name,
            email = seller.email,
            document = seller.document,
            createdAt = seller.createdAt
        )

        fun toDetailsResponseDto(seller: Seller) = SellerDetailsResponseDto(
            data = SellerDataResponseDto(
                id = seller.id,
                name = seller.name,
                email = seller.email,
                document = seller.document,
                wallet = Wallet.toResponseDto(seller.wallet),
                createdAt = seller.createdAt
            )
        )

        fun fromRequestDto(requestDto: SellerRequestDto) = Seller(
            name = requestDto.name,
            email = requestDto.email,
            document = requestDto.document,
            wallet = Wallet(
                balance = requestDto.balance
            )
        )
    }
}
