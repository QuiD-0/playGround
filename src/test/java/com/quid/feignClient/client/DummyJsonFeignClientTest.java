package com.quid.feignClient.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.quid.feignClient.config.FeignTest;
import com.quid.feignClient.model.ProductRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@FeignTest
class DummyJsonFeignClientTest {

    @Autowired
    DummyJsonFeignClient dummyJsonFeignClient;

    @Test
    void test() {
        ResponseEntity<ProductRes> dummyJson = dummyJsonFeignClient.getDummyJson("1");
        System.out.println(dummyJson.getBody());
        assertEquals(200, dummyJson.getStatusCodeValue());
    }

}