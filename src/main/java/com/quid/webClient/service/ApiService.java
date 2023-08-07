package com.quid.webClient.service;

import com.quid.webClient.gateway.client.JsonPlaceHolderClient;
import com.quid.webClient.model.TodoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface ApiService {
    Mono<TodoResponse> execute(Long id);

    @Service
    class ApiServiceImpl implements ApiService {

        private final JsonPlaceHolderClient jsonPlaceHolderClient;

        public ApiServiceImpl(JsonPlaceHolderClient jsonPlaceHolderClient) {
            this.jsonPlaceHolderClient = jsonPlaceHolderClient;
        }

        @Override
        public Mono<TodoResponse> execute(Long id) {
            return jsonPlaceHolderClient.getTodoById(id);
        }
    }

}
