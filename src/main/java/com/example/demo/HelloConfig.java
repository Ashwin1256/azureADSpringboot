package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.azure.spring.cloud.autoconfigure.implementation.aad.security.AadWebApplicationHttpSecurityConfigurer;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity
public class HelloConfig {
	

	@Bean
	   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	       http.apply(AadWebApplicationHttpSecurityConfigurer.aadWebApplication())
	               .and()
	           .authorizeHttpRequests()
	               .anyRequest().authenticated();
	       return http.build();
	   }

}
