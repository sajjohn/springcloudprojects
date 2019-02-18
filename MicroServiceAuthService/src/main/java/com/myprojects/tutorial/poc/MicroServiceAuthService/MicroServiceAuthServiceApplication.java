package com.myprojects.tutorial.poc.MicroServiceAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class MicroServiceAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAuthServiceApplication.class, args);
	}
	
	
}

