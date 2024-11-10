package com.study.payments.domain

class Consumer (
    name: String,
    email: String,
    password: String,
    private val cpf: String
): Person(name, email, password) {
    fun getCpf(): String {
        return cpf
    }
}
