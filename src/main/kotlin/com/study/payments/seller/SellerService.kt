package com.study.payments.seller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SellerService (
    private val repository: SellerRepository
) {
    fun getAllSellers(pagination: Pageable): Page<Seller> = repository.findAllPaginate(pagination)

    fun getSellerDetails(id: String): Seller {
        return repository.findById(id).get()
    }

    fun createSeller(requestDto: SellerRequestDto): Seller {
        val seller = Seller.fromRequestDto(requestDto)

        return repository.save(seller)
    }
}
