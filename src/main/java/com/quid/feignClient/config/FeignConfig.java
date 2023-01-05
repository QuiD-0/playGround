package com.quid.feignClient.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return FeignInterceptor.of();
    }

    @Bean
    public Logger feignLogger() {
        return FeignLogger.of();
    }
}
