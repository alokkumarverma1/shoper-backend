package com.example.shop_service.security;

import ch.qos.logback.core.util.StringUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.util.Collections;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "mySuperSecretKeyForJwtGeneration123456";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // first get token
        String token = getJwtFromRequest(request);

        if(token != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            // now jwt prase hoga and validate token
            try {
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())) // secret key
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                // ge detials

                String username = claims.getSubject();
                Long userId = claims.get("id", Long.class);


                // authentication object creating
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

                //set in springCOntext
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);


            } catch (Exception e) {
                System.out.println("Invalid JWT: " + e.getMessage());
            }
            ;
        }
       // send next filter do mer eko

        filterChain.doFilter(request, response);
    };

    private String getJwtFromRequest(HttpServletRequest request){
        String bearertoken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearertoken) && bearertoken.startsWith("Bearer ")){
            return bearertoken.substring(7);
        }
        return  null;
    }
}
