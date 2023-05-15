package com.example.appjambackend.global.security.jwt;

import com.example.appjambackend.global.error.ErrorResponse;
import com.example.appjambackend.global.error.exception.CustomExceptoin;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtExceptionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomExceptoin e) {
            ErrorResponse error = new ErrorResponse(e.getErrorCode().getMessage());

            response.setContentType("application/json");
            response.setStatus(e.getErrorCode().getStatusCode());
            response.getWriter().write(error.convertToJson(error));
        }
    }
}