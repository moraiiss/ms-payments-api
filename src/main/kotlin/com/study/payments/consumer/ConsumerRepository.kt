package com.study.payments.seller

import com.study.payments.consumer.Consumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsumerRepository : JpaRepository<Consumer, Long>
