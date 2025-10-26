package com.example.demo_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> request
				.anyRequest().authenticated())
				.oauth2Login(oauth2 -> oauth2
						.defaultSuccessUrl("/", false)
						.redirectionEndpoint(redirection -> redirection.baseUri("/callback") // Match your custom
																								// redirect URI
						)).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/")
								.invalidateHttpSession(true).deleteCookies("JSESSIONID"));

		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//This code for default login
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//		  .authorizeHttpRequests(request->request
//				  .anyRequest().authenticated()
//				  ).oauth2Login(Customizer.withDefaults())
//		  
//		          .logout(logout->logout
//		        		  .logoutUrl("/logout")
//		        		  .logoutSuccessUrl("/")
//		        		  .invalidateHttpSession(true)
//		        		  .deleteCookies("JSESSIONID"));
//		
//		http.csrf(csrf->csrf.disable());
//		return http.build();		  
//
//		  
//		  
//	}
	
	
	//OAuth2ClientAutoConfiguration 
		//OAuth2AuthorizedClient
		//ClientRegistrationRepository
		//InMemoryClientRegistrationRepository
		//OAuth2AuthorizedClientManager  using this we can get access token and refresh token 
		//DefaultOAuth2AuthorizationRequestResolver
		//OAuth2LoginAuthenticationFilter

}
