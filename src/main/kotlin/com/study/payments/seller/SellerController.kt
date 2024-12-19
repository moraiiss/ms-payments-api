package com.study.payments.seller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("api/v1/sellers")
@Tag(name = "Seller", description = "Endpoints for seller management")
class SellerController (
    private val service: SellerService
) {
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
        method = "list",
        summary = "List all sellers",
        description = "Return a list of all sellers"
    )
    fun list(
        @RequestParam(defaultValue = "0") pageNumber: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ): ResponseEntity<Page<SellerListResponseDto>> {
        val sellers = service
            .getAllSellers(PageRequest.of(pageNumber, pageSize))

        val response = sellers.map { Seller.toListResponseDto(it) }

        return ResponseEntity.ok(response)
    }

    @GetMapping(
        path = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
        method = "details",
        summary = "Get seller details",
        description = "Return the details of a specific seller"
    )
    fun details(@PathVariable id: String): ResponseEntity<Optional<SellerDetailsResponseDto>> = ResponseEntity
        .ok(service.getSellerDetails(id).map { Seller.toDetailsResponseDto(it) })

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
        method = "create",
        summary = "Create a new seller",
        description = "Return a new seller created"
    )
    fun create(@RequestBody requestDto: SellerRequestDto): ResponseEntity<SellerDetailsResponseDto> = ResponseEntity
        .status(HttpStatus.CREATED)
        .body(Seller.toDetailsResponseDto(service.createSeller(requestDto)))
}
