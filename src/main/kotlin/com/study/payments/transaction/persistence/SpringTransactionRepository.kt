package com.study.payments.transaction.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringTransactionRepository : JpaRepository<TransactionEntity, Long>
