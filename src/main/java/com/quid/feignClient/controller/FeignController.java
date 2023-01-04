package com.quid.feignClient.controller;

import com.quid.feignClient.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign")
public class FeignController {

    private final FeignService feignService;

    @GetMapping("/get")
    public String get() {
        return feignService.callGet();
    }
}
