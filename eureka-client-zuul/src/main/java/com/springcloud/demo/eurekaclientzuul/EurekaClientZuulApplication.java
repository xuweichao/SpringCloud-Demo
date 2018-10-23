package com.springcloud.demo.eurekaclientzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@ComponentScan("com.springcloud.demo.eurekaclientzuul")
public class EurekaClientZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientZuulApplication.class, args);
	}
}
