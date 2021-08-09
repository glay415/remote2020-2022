package com.example.project.jwt;

public interface JwtProperties {
    String SECRET_KEY = "ialohfoiawfnwipenidpsjfnipawenipjsdifjanlowehsdijfadas";
    int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 10;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
