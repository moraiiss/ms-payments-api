package com.study.payments.persistence.entity

import com.study.payments.domain.DocumentTypeEnum
import com.study.payments.domain.PersonTypeEnum
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.math.BigDecimal

@Entity
@Table(name = "persons")
class PersonEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val personType: PersonTypeEnum,
    val documentType: DocumentTypeEnum,
    val document: String,
    val email: String,
    val balance: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)
