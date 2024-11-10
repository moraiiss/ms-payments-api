package com.study.payments.domain

class Consumer (
    name: String,
    email: String,
    password: String,
    private val cpf: String
): Person(name, email, password) {
    init {
        if (cpf.length != 11) {
            throw IllegalArgumentException("CPF must have 11 characters")
        }
    }
}