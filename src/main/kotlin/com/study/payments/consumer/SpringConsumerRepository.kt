package com.study.payments.consumer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringConsumerRepository : JpaRepository<ConsumerEntity, Long>
