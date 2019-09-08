package com.myprojects.tutorial.poc.MicroServiceAuthService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myprojects.tutorial.poc.MicroServiceAuthService.encoders.Encoders;
@Configuration
//@EnableWebSecurity
//@Import(Encoders.class)
public class SecurityServerConfig extends WebSecurityConfigurerAdapter {
	
	

//	@Autowired
//	private BCryptPasswordEncoder userPasswordEncoder;
	
	/*@Autowired
	private UserDetailsService userDetailsService;*/

	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("admin");
		//auth.userDetailsService(userDetailsService).passwordEncoder(userPasswordEncoder);
	}*/
	
	
	 @Autowired
	 public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
		 auth.inMemoryAuthentication()
		 .withUser("admin").password(passwordEncoder().encode("admin")).roles("admin");
	 }
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("tokens/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	

}
