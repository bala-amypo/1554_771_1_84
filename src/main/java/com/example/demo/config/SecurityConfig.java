package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 🚨 THIS IS THE KEY FIX
            .csrf(csrf -> csrf.disable())

            // 🚨 Also disable default login & basic auth
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // 🚨 Allow everything
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
