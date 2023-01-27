package com.quid.feignClient.target.controller;

import com.quid.feignClient.model.BaseReq;
import com.quid.feignClient.model.BaseRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/target")
@RequiredArgsConstructor
public class TargetController {

    @GetMapping("/get")
    public BaseRes get(@RequestHeader("CustomHeaderName") String customHeader,
        @RequestBody BaseReq baseReq) {
        return BaseRes.builder().name(baseReq.getName() + " returned").age(baseReq.getAge())
            .header(customHeader + " returned").build();
    }

    @GetMapping("/error")
    public ResponseEntity error() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/async")
    public String async() throws InterruptedException {
        Thread.sleep(1000);
        return "async";
    }

    @GetMapping("/sleep/{ms}")
    public String sleep(@PathVariable int ms) throws InterruptedException {
        Thread.sleep(ms);
        return "sleep : " + ms + "ms";
    }
}
