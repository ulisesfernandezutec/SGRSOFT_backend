package com.sgr.bussines.security;

import java.io.IOException;
import javax.servlet.FilterChain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
)
public class WebSecurityConfig {

	 @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 Exception { http.cors().and().csrf().disable() .authorizeHttpRequests((authz)
	 -> authz .anyRequest().authenticated()).httpBasic(withDefaults());
	 return http.build(); }

	/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated().and().oauth2Login().defaultSuccessUrl("/swagger-ui/index.html");

		return http.build();
	}*/
}