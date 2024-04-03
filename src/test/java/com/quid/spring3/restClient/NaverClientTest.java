package com.quid.spring3.restClient;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Disabled
class NaverClientTest {
    RestClientConfig config = new RestClientConfig();

    @Test
    void getNaver() {
        NaverClient naverClient = new NaverClient(config.restClient());
        ResponseEntity<String> response = naverClient.getNaver();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}