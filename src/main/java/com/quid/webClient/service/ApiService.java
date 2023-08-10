package com.quid.webClient.service;

import com.quid.webClient.gateway.client.JsonPlaceHolderClient;
import com.quid.webClient.model.TodoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface ApiService {
    Mono<TodoResponse> getTodo(Long id);

    void log();

    @Service
    class ApiServiceImpl implements ApiService {

        private final JsonPlaceHolderClient jsonPlaceHolderClient;

        public ApiServiceImpl(JsonPlaceHolderClient jsonPlaceHolderClient) {
            this.jsonPlaceHolderClient = jsonPlaceHolderClient;
        }

        @Override
        public Mono<TodoResponse> getTodo(Long id) {
            return jsonPlaceHolderClient.getTodoById(id);
        }

        @Override
        public void log() {
            jsonPlaceHolderClient.log();
        }
    }

}
