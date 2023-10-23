package com.quid.webClient.gateway.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class JsonPlaceHolderConfig {

    private final WebClient webClient;

    public JsonPlaceHolderConfig() {
        this.webClient = WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com/todos/")
            .defaultHeader("Content-Type", "application/json")
            .build();
    }

    @Bean
    public WebClient jsonPlaceHolderWebClient() {
        return new JsonPlaceHolderConfig().webClient;
    }


}
