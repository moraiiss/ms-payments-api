package com.study.payments.seller

import com.study.payments.wallet.WalletResponseDto
import java.time.LocalDateTime

data class SellerDetailsResponseDto(
    val data: SellerDataResponseDto
)

data class SellerDataResponseDto(
    val id: String?,
    val name: String,
    val email: String,
    val document: String,
    val wallet: WalletResponseDto,
    val createdAt: LocalDateTime,
)
