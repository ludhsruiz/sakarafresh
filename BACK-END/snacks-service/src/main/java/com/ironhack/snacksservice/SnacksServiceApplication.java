package com.ironhack.snacksservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SnacksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnacksServiceApplication.class, args);
	}

}
