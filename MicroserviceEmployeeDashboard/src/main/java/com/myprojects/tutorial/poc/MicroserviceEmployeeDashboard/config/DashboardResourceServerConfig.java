package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.config.xml.ResourceServerBeanDefinitionParser;

@Configuration
@EnableResourceServer
public class DashboardResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID="resource-server-rest-api";	
	
	final private ResourceServerpro
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.resourceId(RESOURCE_ID);
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/" ).permitAll()
                .anyRequest().authenticated();
    }

}
