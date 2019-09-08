package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.config.xml.ResourceServerBeanDefinitionParser;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class DashboardResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID="resource-server-rest-api";	
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.tokenServices(tokenServices());
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.and().authorizeRequests().anyRequest().permitAll();
        
    }
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices(){
		final DefaultTokenServices defaultTokenServices= new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter(){
		final JwtAccessTokenConverter converter= new JwtAccessTokenConverter();
		converter.setSigningKey("123");
		return converter;
	
	}
	
	@Bean
	public TokenStore tokenStore(){
		//return new JdbcTokenStore(dataSource);
		return new JwtTokenStore(accessTokenConverter());
	}

}
