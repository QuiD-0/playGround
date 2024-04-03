package com.quid.spring3.restClient;

import org.springframework.web.client.RestClient;

public class NaverClient {

    private final RestClient restClient;

    public NaverClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getNaver() {
        return restClient.get()
            .retrieve()
            .toEntity(String.class)
            .getBody();
    }

}
