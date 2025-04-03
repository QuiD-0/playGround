package com.quid.resilience4j

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class DemoClient(
    private val client: RestClient
) {
    private val log = LoggerFactory.getLogger(this::class.java)!!

    @Retry(name = "demoClient", fallbackMethod = "retryFallback")
    @CircuitBreaker(name = "demoClient", fallbackMethod = "fallback")
    fun getData(): String {
        return client.get()
            .retrieve()
            .toEntity(String::class.java)
            .body!!
    }

    fun retryFallback(ex: Throwable): String {
        log.error(ex.message, ex)
        return "Retry fallback response"
    }

    fun fallback(ex: Throwable): String {
        log.error(ex.message, ex)
        return "Fallback response"
    }
}

