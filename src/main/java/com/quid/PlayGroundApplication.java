package com.quid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PlayGroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayGroundApplication.class, args);
    }

}
