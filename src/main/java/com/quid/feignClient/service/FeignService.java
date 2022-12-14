package com.quid.feignClient.service;

import com.quid.feignClient.client.DummyJsonFeignClient;
import com.quid.feignClient.client.TargetFeignClient;
import com.quid.feignClient.model.BaseReq;
import com.quid.feignClient.model.BaseRes;
import com.quid.feignClient.model.ProductRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final TargetFeignClient targetFeignClient;
    private final DummyJsonFeignClient dummyJsonFeignClient;

    public ResponseEntity<BaseRes> callGet() {
        BaseReq baseReq = BaseReq.builder()
            .name("quid").age(25L).build();
        return targetFeignClient.callGet("CustomHeader", baseReq);
    }

    public ResponseEntity<ProductRes> callDummyJson(String id) {
        return dummyJsonFeignClient.getDummyJson(id);
    }

    public String callError() {
        targetFeignClient.callError();
        return "error";
    }
}
