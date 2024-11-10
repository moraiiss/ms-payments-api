package com.study.payments.domain

class Seller (
    name: String,
    email: String,
    password: String,
    private val cnpj: String
): Person(name, email, password) {
    init {
        if (cnpj.length != 14) {
            throw IllegalArgumentException("CNPJ must have 14 characters")
        }
    }
}