package com.quid.spring3.restClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class NaverClient {

    private final RestClient restClient;

    public NaverClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public ResponseEntity<String> getNaver() {
        return restClient.get()
            .retrieve()
            .onStatus(it -> it.is4xxClientError() || it.is5xxServerError(),
                ((request, response) -> {
                    throw new RuntimeException("Error");
                }))
            .toEntity(String.class);
    }

}
