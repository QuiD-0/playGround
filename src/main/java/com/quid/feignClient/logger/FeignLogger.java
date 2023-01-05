package com.quid.feignClient.logger;

import feign.Logger;
import feign.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class FeignLogger extends Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {
        log.info(methodTag(configKey) + format, args);
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info("Request: " + request.toString());
    }

}
