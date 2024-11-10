package com.study.payments.domain

class Seller (
    name: String,
    email: String,
    password: String,
    private val cnpj: String
): Person(name, email, password) {
    fun getCnpj(): String {
        return cnpj
    }
}
