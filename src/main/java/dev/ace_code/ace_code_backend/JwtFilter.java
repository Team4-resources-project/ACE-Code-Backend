package dev.ace_code.ace_code_backend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                username = JWT.require(Algorithm.HMAC512("secret".getBytes()))
                        .build()
                        .verify(token)
                        .getSubject();
            } catch (Exception e) {
                System.out.println("Token inválido: " + e.getMessage());
            }
        }

        if (username != null) {
            request.setAttribute("username", username);
        }

        filterChain.doFilter(request, response);
    }
}