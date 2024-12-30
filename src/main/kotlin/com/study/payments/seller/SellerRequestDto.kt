package com.study.payments.seller

import java.math.BigDecimal

data class SellerRequestDto(
    val name: String,
    val email: String,
    val document: String,
    val balance: BigDecimal,
) {
    companion object
}
