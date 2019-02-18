package com.myprojects.tutorial.poc.MicroServiceAuthService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myprojects.tutorial.poc.MicroServiceAuthService.encoders.Encoders;
@Configuration
@EnableWebSecurity
@Import(Encoders.class)
public class SecurityServerConfig extends WebSecurityConfigurerAdapter {
	
	

	@Autowired
	private PasswordEncoder userPasswordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(userPasswordEncoder);
	}

}
