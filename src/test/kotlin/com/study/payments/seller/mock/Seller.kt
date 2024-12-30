package com.study.payments.seller.mock

import com.study.payments.seller.Seller
import com.study.payments.wallet.Wallet
import java.math.BigDecimal
import java.util.Optional

fun Seller.Companion.mock() = Optional.of(
    Seller(
        name = "seller name",
        email = "seller@mail.com",
        document = "12312312312",
        wallet = Wallet(
            balance = BigDecimal.ZERO
        )
    )
)