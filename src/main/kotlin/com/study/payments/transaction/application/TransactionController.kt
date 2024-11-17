package com.study.payments.transaction.application

import com.study.payments.transaction.core.Transaction
import com.study.payments.transaction.core.TransactionService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        @RequestBody transactionDto: TransactionRequestDto
    ): ResponseEntity<Transaction> {
        val transaction = Transaction.fromTransactionDto(transactionDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.createTransaction(transaction))
    }
}
