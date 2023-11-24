package com.quid.webClient.service;

import com.quid.webClient.gateway.client.JsonPlaceHolderClient;
import com.quid.webClient.model.TodoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    Mono<TodoResponse> getTodo(Long id);

    Flux<TodoResponse> getTodos();

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
        public Flux<TodoResponse> getTodos() {
            Mono<TodoResponse> todo1 = jsonPlaceHolderClient.getTodoById(1L);
            Mono<TodoResponse> todo2 = jsonPlaceHolderClient.getTodoById(2L);
            Mono<TodoResponse> todo3 = jsonPlaceHolderClient.getTodoById(3L);

            return Flux.concat(todo1, todo2, todo3);
        }

        @Override
        public void log() {
            jsonPlaceHolderClient.log();
        }
    }

}
