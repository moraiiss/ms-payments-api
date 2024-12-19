package com.study.payments.seller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class SellerService (
    private val repository: SellerRepository
) {
    fun getAllSellers(pagination: Pageable): Page<Seller> = repository.findAllPaginate(pagination)

    fun getSellerDetails(id: String): Optional<Seller> = repository.findById(id)

    fun createSeller(requestDto: SellerRequestDto): Seller {
        return repository.save(Seller.fromRequestDto(requestDto))
    }
}
