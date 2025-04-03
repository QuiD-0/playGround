package com.quid.resilience4j

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration.ofSeconds


@Configuration
class Resilience4jConfig {

    @Bean
    fun circuitBreakerConfig(): CircuitBreakerRegistry {
        return CircuitBreakerRegistry.of(
            CircuitBreakerConfig.custom()
                .failureRateThreshold(30f)
                .waitDurationInOpenState(ofSeconds(10))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .permittedNumberOfCallsInHalfOpenState(3)
                .build()
        )
    }
}
