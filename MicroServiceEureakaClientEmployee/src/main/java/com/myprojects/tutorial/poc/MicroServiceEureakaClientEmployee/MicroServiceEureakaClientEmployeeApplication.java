package com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableMongoRepositories("com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee")
public class MicroServiceEureakaClientEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceEureakaClientEmployeeApplication.class, args);
	}
}
