package com.study.payments.wallet

import java.math.BigDecimal

data class WalletResponseDto(
    val id: String,
    val balance: BigDecimal,
)
