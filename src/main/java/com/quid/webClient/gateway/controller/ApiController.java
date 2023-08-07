package com.quid.webClient.gateway.controller;

import com.quid.webClient.model.TodoResponse;
import com.quid.webClient.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @RequestMapping("/{id}")
    public Mono<TodoResponse> test(@PathVariable("id") Long id) {
        return apiService.getTodo(id);
    }
}
