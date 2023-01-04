package com.quid.feignClient.service;

import com.quid.feignClient.client.FeignDemoClient;
import com.quid.feignClient.model.BaseReq;
import com.quid.feignClient.model.BaseRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final FeignDemoClient feignDemoClient;

    public String callGet() {
        BaseReq baseReq = BaseReq.builder()
            .name("quid").age(25L).build();
        ResponseEntity<BaseRes> res = feignDemoClient.callGet("CustomHeader", baseReq);
        System.out.println(res.getBody());
        return "get";
    }

}
