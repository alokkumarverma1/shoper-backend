package com.example.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class MainSecurity {


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
//        httpSecurity.authorizeHttpRequests(auth -> auth
//                .requestMatchers("user/test", "/user/register", "/user/login").permitAll()
//                .anyRequest().authenticated()
//        )
//                .sessionManagement(sess-> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//         httpSecurity.addFilter()
//    }
//
//
}