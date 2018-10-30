package com.springcloud.demo.eurekaclientzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrixDashboard
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@ComponentScan("com.springcloud.demo.eurekaclientzipkin")
public class EurekaClientZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientZipkinApplication.class, args);
	}
}
