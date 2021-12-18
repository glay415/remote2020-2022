package com.example.appjambackend.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class jwtProvider {

    private final JwtProperties jwtProperties;

    public String generateAccess(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("type", "access")
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000)
                )
                .setIssuedAt(new Date())
                .compact();
    }
}
