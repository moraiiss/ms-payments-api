package com.study.payments.transaction

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/transactions")
@Tag(name = "Transactions")
class TransactionController (private val service: TransactionService) {
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
        method = "createTransaction",
        summary = "Create a new transaction",
        description = "Create a new transaction",
    )
    fun createTransaction(
        @RequestBody requestDto: TransactionRequestDto
    ): ResponseEntity<Transaction> {

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.executeTransfer(requestDto.payer, requestDto.payee, requestDto.amount))
    }
}
