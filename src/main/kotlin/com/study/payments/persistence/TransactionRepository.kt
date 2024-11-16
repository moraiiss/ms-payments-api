package com.study.payments.persistence

import com.study.payments.persistence.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<TransactionEntity, Long>
