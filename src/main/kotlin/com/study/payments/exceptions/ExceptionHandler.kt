package com.study.payments.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.resource.NoResourceFoundException

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(
        exception: DataIntegrityViolationException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionResponseDto> {
        
        val errorResponse = ExceptionResponseDto(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = exception.message.toString(),
            path = request.servletPath
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionResponseDto> {
        
        val errorResponse = ExceptionResponseDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message.toString(),
            path = request.servletPath
        )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(
        exception: NoResourceFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionResponseDto> {
        
        val errorResponse = ExceptionResponseDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message.toString(),
            path = request.servletPath
        )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionResponseDto> {

        val errorResponse = ExceptionResponseDto(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message.toString(),
            path = request.servletPath
        )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
}
