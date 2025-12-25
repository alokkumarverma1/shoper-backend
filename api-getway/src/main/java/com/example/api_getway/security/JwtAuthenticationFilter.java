//package com.example.api_getway.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.JwtException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
//@Component
//public class JwtAuthenticationFilter implements WebFilter {
//
//    // Same secret jo token banate waqt use kiya tha
//    private static final String SECRET_KEY =
//            "mySuperSecretKeyForJwtGeneration123456";
//
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//
//        if (exchange.getRequest().getMethod().name().equals("OPTIONS")) {
//            return chain.filter(exchange);
//        }
//
//        String authHeader = exchange.getRequest()
//                .getHeaders()
//                .getFirst(HttpHeaders.AUTHORIZATION);
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            return unauthorized(exchange);
//        }
//
//        String token = authHeader.substring(7);
//
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            return chain.filter(exchange);
//
//        } catch (JwtException e) {
//            return unauthorized(exchange);
//        }
//    }
//
//
//    private Mono<Void> unauthorized(ServerWebExchange exchange) {
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//        return exchange.getResponse().setComplete();
//    }
//}
