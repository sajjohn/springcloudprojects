package com.myprojects.tutorial.poc.MicroServiceEureakaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MicroServiceEureakaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceEureakaServerApplication.class, args);
	}
}
