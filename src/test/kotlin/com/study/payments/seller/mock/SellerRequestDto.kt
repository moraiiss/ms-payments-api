package com.study.payments.seller.mock

import com.study.payments.seller.SellerRequestDto
import java.math.BigDecimal

fun SellerRequestDto.Companion.mock() = SellerRequestDto(
    name = "teste",
    email = "example@mail.com",
    document = "123456789",
    balance = BigDecimal.ZERO
)