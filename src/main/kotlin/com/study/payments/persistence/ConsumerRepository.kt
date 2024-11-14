package com.study.payments.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.study.payments.persistence.entity.ConsumerEntity

@Repository
interface ConsumerRepository : JpaRepository<ConsumerEntity, Long>
