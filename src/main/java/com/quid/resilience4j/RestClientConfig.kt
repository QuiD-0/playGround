package com.quid.resilience4j

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restclient(): RestClient {
        return RestClient.builder()
            .baseUrl("http://localhost:8080/test/random")
            .build()
    }
}
