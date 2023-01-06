package com.quid.feignClient.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder;

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            log.error("404 error took place when calling " + methodKey + " with status "
                + response.status() + " and body " + response.body());
            throw new RuntimeException(
                "404 error took place when calling " + methodKey + " with status "
                    + response.status() + " and body " + response.body());
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
