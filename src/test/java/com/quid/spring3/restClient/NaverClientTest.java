package com.quid.spring3.restClient;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class NaverClientTest {
    RestClientConfig config = new RestClientConfig();

    @Test
    void getNaver() {
        NaverClient naverClient = new NaverClient(config.restClient());
        String test = naverClient.getNaver();
        System.out.println(test);
    }

}