//package com.example.api_getway.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//
//@Configuration
//@EnableWebFluxSecurity
//public class MainSecurity {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(
//            ServerHttpSecurity http,
//            JwtAuthenticationFilter jwtFilter) {
//
//        return http
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange(exchange -> exchange
//                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
//                        .pathMatchers(
//                                "/user/register",
//                                "/user/login",
//                                "/user/userDetailsShop"
//                        ).permitAll()
//                        .pathMatchers("/shop/create").hasRole("USER")
//                        .anyExchange().authenticated()
//                )
////                .addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION)
//                .build();
//    }
//
//
//};
