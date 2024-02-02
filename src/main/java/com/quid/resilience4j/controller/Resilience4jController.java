//package com.quid.resilience4j.controller;
//
//import com.quid.resilience4j.service.Resilience4jService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/resilience4j")
//public class Resilience4jController {
//
//    private final Resilience4jService resilience4jService;
//
//    @GetMapping("/circuitBreaker")
//    public void circuitBreaker() {
//        resilience4jService.callCircuitBreaker();
//    }
//
//    @GetMapping("/retry")
//    public void retry() {
//        resilience4jService.callRetry();
//    }
//
//}
