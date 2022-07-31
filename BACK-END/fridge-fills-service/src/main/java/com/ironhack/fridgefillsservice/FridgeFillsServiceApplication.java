package com.ironhack.fridgefillsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FridgeFillsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridgeFillsServiceApplication.class, args);
	}

}
