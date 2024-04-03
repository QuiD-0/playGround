package com.quid.spring3.restClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClient;

@Slf4j
public class RestClientConfig {

    public RestClient restClient() {
        return RestClient.builder()
            .baseUrl("https://www.naver.com")
            .requestInterceptor((request, body, execution) -> {
                log.info("Request: {}", request);
                return execution.execute(request, body);
            })
            .build();
    }



}
