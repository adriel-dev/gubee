package com.example.adapter.product.`in`.web

import exception.ResourceAlreadyPresentException
import exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(): ResponseEntity<Any> {
        return status(HttpStatus.NOT_FOUND).build()
    }

    @ExceptionHandler(ResourceAlreadyPresentException::class)
    fun handleResourceAlreadyPresentException(): ResponseEntity<Any> {
        return status(HttpStatus.CONFLICT).build()
    }

}