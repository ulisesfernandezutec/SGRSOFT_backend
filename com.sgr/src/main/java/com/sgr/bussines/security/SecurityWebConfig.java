package com.sgr.bussines.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().addFilterAfter(new SecurityJWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.GET, "/glogin/**").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.anyRequest().authenticated();

	}
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
	    }
	}