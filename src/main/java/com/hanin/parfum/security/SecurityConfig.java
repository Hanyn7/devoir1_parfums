package com.hanin.parfum.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
	http.csrf().disable().sessionManagement()
	 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	 
	 .cors().configurationSource(new CorsConfigurationSource() {
		 @Override
		 public CorsConfiguration getCorsConfiguration(HttpServletRequest
		request) {
		 CorsConfiguration config = new CorsConfiguration();

		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		 config.setAllowedMethods(Collections.singletonList("*"));
		 config.setAllowCredentials(true);
		 config.setAllowedHeaders(Collections.singletonList("*"));
		 config.setExposedHeaders(Arrays.asList("Authorization"));
		 config.setMaxAge(3600L);
		 return config;
		 }
		 }).and();

	 //.authorizeHttpRequests().anyRequest().permitAll();
	 /*.authorizeHttpRequests()
	 .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
	 .requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN","USER")
	 .requestMatchers(HttpMethod.POST,"/api/addparf/**").hasAnyAuthority("ADMIN")
	 .requestMatchers(HttpMethod.PUT,"/api/updateparf/**").hasAuthority("ADMIN")
	 .requestMatchers(HttpMethod.DELETE,"/api/delparf/**").hasAuthority("ADMIN")
	 .requestMatchers(HttpMethod.GET,"/prodscat/**").hasAuthority("ADMIN")
		.requestMatchers(HttpMethod.GET,"/prodsByName/**").hasAuthority("ADMIN")
		.anyRequest().authenticated().and()
	 //.requestMatchers(HttpMethod.GET,"/api/image/loadfromFS/**").hasAnyAuthority("ADMIN","USER")
	 //.requestMatchers(HttpMethod.GET,"/api/image/load/**").hasAnyAuthority("ADMIN","USER")
	 //.requestMatchers(HttpMethod.POST,"/api/image/uploadFS/**").hasAuthority("ADMIN")
	 .addFilterBefore(new JWTAuthorizationFilter(),BasicAuthenticationFilter.class);*/
	return http.build();
	}

}