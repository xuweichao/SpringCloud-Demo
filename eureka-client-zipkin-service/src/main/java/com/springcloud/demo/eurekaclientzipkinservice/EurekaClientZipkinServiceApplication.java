package com.springcloud.demo.eurekaclientzipkinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientZipkinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientZipkinServiceApplication.class, args);
	}
}
