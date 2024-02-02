//package com.quid.feignClient.config;
//
//import feign.Logger;
//import feign.Retryer;
//import feign.codec.ErrorDecoder;
//import feign.codec.ErrorDecoder.Default;
//import java.util.concurrent.TimeUnit;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignConfig {
//
//    @Bean
//    public FeignInterceptor feignInterceptor() {
//        return FeignInterceptor.of();
//    }
//
//    @Bean
//    public Logger feignLogger() {
//        return FeignLogger.of();
//    }
//
//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return FeignErrorDecoder.of(new Default());
//    }
//
//    @Bean
//    public Retryer.Default retryer() {
//        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(3L), 5);
//    }
//}
