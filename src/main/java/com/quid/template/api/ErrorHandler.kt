package com.quid.template.api

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {
    private val log = LoggerFactory.getLogger(ErrorHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<Error> =
        ResponseEntity(
            Error { ex.message ?: "Unknown Error" },
            HttpStatusSelector { ex }
        ).also {
            log.error("[ERROR] ${ex.message}")
            ex.printStackTrace()
        }
}