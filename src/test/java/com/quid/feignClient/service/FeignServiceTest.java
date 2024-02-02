package com.quid.feignClient.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class FeignServiceTest {

    @Autowired
    FeignService feignService;

    @Test
    void getDummy() {
        feignService.callDummyJson("1");
    }

    @Test
    void returnAsyncList() {
        System.out.println(feignService.returnAsyncList());
    }
}