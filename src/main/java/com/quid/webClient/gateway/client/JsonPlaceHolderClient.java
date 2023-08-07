package com.quid.webClient.gateway.client;

import com.quid.webClient.model.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface JsonPlaceHolderClient {

    Mono<TodoResponse> getTodoById(Long id);

    @Component
    @RequiredArgsConstructor
    class JsonPlaceHolderClientImpl implements JsonPlaceHolderClient {

        private final WebClient jsonPlaceHolderWebClient;

        @Override
        public Mono<TodoResponse> getTodoById(Long id) {
            return jsonPlaceHolderWebClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(TodoResponse.class);
            }
    }
}
