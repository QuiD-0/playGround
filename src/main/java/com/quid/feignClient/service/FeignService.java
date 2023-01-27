package com.quid.feignClient.service;

import com.quid.feignClient.client.DummyJsonFeignClient;
import com.quid.feignClient.client.TargetFeignClient;
import com.quid.feignClient.model.BaseReq;
import com.quid.feignClient.model.BaseRes;
import com.quid.feignClient.model.ProductRes;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final TargetFeignClient targetFeignClient;
    private final DummyJsonFeignClient dummyJsonFeignClient;

    public BaseRes callGet() {
        BaseReq baseReq = BaseReq.builder().name("quid").age(25L).build();
        return targetFeignClient.callGet("CustomHeader", baseReq).getBody();
    }

    public ProductRes callDummyJson(String id) {
        return dummyJsonFeignClient.getDummyJson(id).getBody();
    }

    public String callError() {
        targetFeignClient.callError();
        return "error";
    }

    public String callAsync() {
        IntStream.range(0, 10).forEach(
            i -> CompletableFuture.supplyAsync(targetFeignClient::callAsync)
                .thenAccept(System.out::println)
                .exceptionally(this::apply));
        return "async";
    }

    public ProductRes returnAsync() {
        return CompletableFuture.supplyAsync(() -> dummyJsonFeignClient.getDummyJson("1"))
            .thenApply(ResponseEntity::getBody).join();
    }

    public List<ProductRes> returnAsyncList() {
        return IntStream.range(0, 10).parallel().mapToObj(num -> CompletableFuture.supplyAsync(
                    () -> dummyJsonFeignClient.getDummyJson(String.valueOf(num)),
                    Executors.newFixedThreadPool(10))
                .thenApply(ResponseEntity::getBody)
                .exceptionally(this::apply))
            .map(CompletableFuture::join).toList();
    }

    private <T> T apply(Throwable e) {
        System.out.println(e.getMessage());
        return null;
    }

}
