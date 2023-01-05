package com.quid.feignClient.config;

import com.quid.feignClient.intercepter.FeignInterceptor;
import com.quid.feignClient.logger.FeignLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return FeignInterceptor.of();
    }

    @Bean
    public FeignLogger feignLogger() {
        return FeignLogger.of();
    }
}
