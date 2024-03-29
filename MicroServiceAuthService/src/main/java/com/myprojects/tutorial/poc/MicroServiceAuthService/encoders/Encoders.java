package com.myprojects.tutorial.poc.MicroServiceAuthService.encoders;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoders {
	
	 	@Bean
	    public PasswordEncoder oauthClientPasswordEncoder() {
	        return new BCryptPasswordEncoder(4);
	    }

	    @Bean
	    public PasswordEncoder userPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
