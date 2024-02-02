package com.quid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@EnableFeignClients
@ServletComponentScan
@SpringBootApplication
public class PlayGroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayGroundApplication.class, args);
    }

}
