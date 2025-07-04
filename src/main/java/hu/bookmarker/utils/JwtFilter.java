package hu.bookmarker.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain chain) throws ServletException, IOException {
        
        final String tokenHeader = request.getHeader("Authorization");

        String jwtToken = null;
        String userId = null;
        
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            jwtToken = tokenHeader.substring(7);

            try {
                userId = jwtUtil.validateToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("JWT 토큰을 가져올 수 없습니다");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT 토큰이 만료되었습니다");
            } catch (Exception e) {
                System.out.println("JWT 검증 실패: " + e.getMessage());
            }
        }
        
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
         }

        chain.doFilter(request, response);
    }
} 
