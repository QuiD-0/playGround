package com.quid.resilience4j.service;

import com.quid.feignClient.client.TargetFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Resilience4jService {

    private final TargetFeignClient targetFeignClient;

    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "fallback")
    public void callCircuitBreaker() {
        System.out.println(targetFeignClient.sendRequest(6000));
    }

    private void fallback(Throwable t) {
        System.out.println("fallback");
    }

    @Retry(name = "retry", fallbackMethod = "retryFallback")
    public void callRetry() {
        System.out.println(targetFeignClient.sendRequest(6000));
    }

    private void retryFallback(Throwable t) {
        System.out.println("[retryFallback] :" + t.getMessage());
    }

}