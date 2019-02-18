package com.myprojects.tutorial.poc.MicroServiceAuthService.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.myprojects.tutorial.poc.MicroServiceAuthService.encoders.Encoders;
@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Import(SecurityServerConfig.class)
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter{
	
@Autowired
@Qualifier("dataSource")
private DataSource dataSource;

@Autowired
@Qualifier("authenticationManagerBean")
private AuthenticationManager authenticationManager;

@Autowired
private PasswordEncoder oauthClientPasswordEncoder;

@Autowired
private UserDetailsService userDetailsService;
	
	private TokenStore tokenStore(){
		return new JdbcTokenStore(dataSource);
	}


@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthserver) throws Exception {
		// TODO Auto-generated method stub
	oauthserver.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(oauthClientPasswordEncoder);
	}


	@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// TODO Auto-generated method stub
			clients.jdbc(dataSource);
		}

	
	@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(userDetailsService);
			
		}






}
