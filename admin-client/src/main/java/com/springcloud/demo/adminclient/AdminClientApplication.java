package com.springcloud.demo.adminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminClientApplication.class, args);
	}
}
