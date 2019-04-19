package com.ahmadgilang.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ahmadgilang.apps.service.impl.ReadInsertData;

@SpringBootApplication(scanBasePackages="com.ahmadgilang.apps")
public class InsertDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InsertDataApplication.class, args);
		ReadInsertData service =  context.getBean(ReadInsertData.class);
		service.executeData();
	}

}

