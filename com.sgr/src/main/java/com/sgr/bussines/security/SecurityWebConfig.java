package com.sgr.bussines.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.addFilterAfter(new SecurityJWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/glogin/**").permitAll()
				.antMatchers(HttpMethod.POST, "/login/**").permitAll()
				.antMatchers(HttpMethod.GET, "/login/**").permitAll()
				.anyRequest().authenticated();
		return http.build();
	}
	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

	}/*
	 @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source =
	            new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }*/
	@Bean
	public CorsFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("https://api.karaiguazu.com", "https://www.karaiguazu.com"));
		corsConfig.setMaxAge(3600L);
		corsConfig.addAllowedMethod("*");
		corsConfig.addAllowedHeader("Requestor-Type");
		corsConfig.addExposedHeader("X-Get-Header");

		UrlBasedCorsConfigurationSource source =
				new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new  new CorsFilter(source);
	}

	@Bean
	public ClassLoaderTemplateResolver secondaryTemplateResolver() {
		ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
		secondaryTemplateResolver.setPrefix("templates/");
		secondaryTemplateResolver.setSuffix(".html");
		secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
		secondaryTemplateResolver.setCharacterEncoding("UTF-8");
		secondaryTemplateResolver.setOrder(1);
		secondaryTemplateResolver.setCheckExistence(true);
		return secondaryTemplateResolver;
		}
}

