package com.ahmadgilang.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.ahmadgilang.apps")
public class InsertDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertDataApplication.class, args);
	}

}

