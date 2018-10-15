package telran.cars.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class CarsSecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity httpSecurity) throws Exception{
	httpSecurity.httpBasic();//each request should contain username and password
	httpSecurity.csrf().disable();//csrf tokens are disabled for POST  requests
	httpSecurity.authorizeRequests().anyRequest().authenticated();//authorization canceled
	
}
}
