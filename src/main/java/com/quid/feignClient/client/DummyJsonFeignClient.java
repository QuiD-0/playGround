package com.quid.feignClient.client;

import com.quid.feignClient.model.ProductRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dummyJsonClient", url = "https://dummyjson.com/products")
public interface DummyJsonFeignClient {

    @GetMapping("{id}")
    ResponseEntity<ProductRes> getDummyJson(@PathVariable String id);
}
