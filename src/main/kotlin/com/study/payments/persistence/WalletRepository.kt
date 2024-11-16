package com.study.payments.persistence

import com.study.payments.persistence.entity.WalletEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository : JpaRepository<WalletEntity, Long>
