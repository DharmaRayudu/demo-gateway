package com.example.demo_gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		  .authorizeHttpRequests(request->request
				  .anyRequest().authenticated()
				  ).oauth2Login(Customizer.withDefaults())
		  
		          .logout(logout->logout
		        		  .logoutUrl("/logout")
		        		  .logoutSuccessUrl("/")
		        		  .invalidateHttpSession(true)
		        		  .deleteCookies("JSESSIONID"));
		
		http.csrf(csrf->csrf.disable());
		return http.build();		  

		  
		  
	}

}
