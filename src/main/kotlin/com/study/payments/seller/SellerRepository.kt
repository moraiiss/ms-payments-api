package com.study.payments.seller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SellerRepository : JpaRepository<Seller, Long> {
    @Query("SELECT s FROM Seller s ORDER BY s.createdAt DESC")
    fun findAllPaginate(pagination: Pageable): Page<Seller>
    fun findById(id: String): Optional<Seller>
}
