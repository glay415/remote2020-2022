package com.example.project.config.jwt;

public interface JwtProperties {
    String SECRET = "DMS";
    int EXPIRATION_TIME = 864000000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
