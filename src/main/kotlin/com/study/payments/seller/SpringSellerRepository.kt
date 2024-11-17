package com.study.payments.seller

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringSellerRepository : JpaRepository<SellerEntity, Long>
