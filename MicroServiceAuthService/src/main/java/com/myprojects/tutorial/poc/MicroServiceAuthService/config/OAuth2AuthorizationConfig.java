package com.myprojects.tutorial.poc.MicroServiceAuthService.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.myprojects.tutorial.poc.MicroServiceAuthService.encoders.Encoders;
@Configuration
@EnableAuthorizationServer
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter{
	
/*@Autowired
@Qualifier("dataSource")
private DataSource dataSource;*/

@Autowired
@Qualifier("authenticationManagerBean")
private AuthenticationManager authenticationManager;

//@Autowired
//private BCryptPasswordEncoder oauthClientPasswordEncoder;

/*@Autowired
private UserDetailsService userDetailsService;*/
	
	@Bean
	public TokenStore tokenStore(){
		//return new JdbcTokenStore(dataSource);
		return new JwtTokenStore(accessTokenConverter());
	}


	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthserver) throws Exception {
		// TODO Auto-generated method stub
	oauthserver.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	//.passwordEncoder(oauthClientPasswordEncoder);
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


	@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// TODO Auto-generated method stub
			//clients.jdbc(dataSource);
			clients.inMemory()
			.withClient("ui")
			.secret(passwordEncoder().encode("secret"))
			.authorizedGrantTypes("authorization_code","refresh_token")
			.scopes("read","write")
			.accessTokenValiditySeconds(3600)
			.refreshTokenValiditySeconds(2592000)
			.redirectUris("http://localhost:4200");
			
		}

	
	@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter()).authenticationManager(authenticationManager);
		//.userDetailsService(userDetailsService);
			
		}


		@Bean
		public BCryptPasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
		}



}
