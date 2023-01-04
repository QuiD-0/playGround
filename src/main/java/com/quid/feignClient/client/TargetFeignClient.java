package com.quid.feignClient.client;

import com.quid.feignClient.model.BaseReq;
import com.quid.feignClient.model.BaseRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "feignClient", url = "http://localhost:8080/target")
public interface TargetFeignClient {

    @GetMapping("/get")
    ResponseEntity<BaseRes> callGet(@RequestHeader("CustomHeaderName") String customHeader,
        @RequestBody BaseReq baseReq);
}
