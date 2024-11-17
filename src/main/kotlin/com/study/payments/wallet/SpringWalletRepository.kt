package com.study.payments.wallet

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringWalletRepository : JpaRepository<WalletEntity, Long>
