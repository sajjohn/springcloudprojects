package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
@EnableDiscoveryClient
@EnableFeignClients
@EnableOAuth2Client
@SpringBootApplication
@EnableCircuitBreaker
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MicroserviceEmployeeDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEmployeeDashboardApplication.class, args);
	}
}
