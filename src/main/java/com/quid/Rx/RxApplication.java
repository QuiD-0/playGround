package com.quid.Rx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxApplication.class, args);
	}

}
