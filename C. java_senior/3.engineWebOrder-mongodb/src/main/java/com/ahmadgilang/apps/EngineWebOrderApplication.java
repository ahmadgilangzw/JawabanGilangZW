package com.ahmadgilang.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.ahmadgilang.apps")
public class EngineWebOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineWebOrderApplication.class, args);
	}

}

