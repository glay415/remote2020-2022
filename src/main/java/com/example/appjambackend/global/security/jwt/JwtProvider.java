package com.example.appjambackend.global.security.jwt;

import com.example.appjambackend.domain.user.entity.refresh.RefreshToken;
import com.example.appjambackend.domain.user.entity.refresh.RefreshTokenRepository;
import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse generateToken(String username) {
        String access = generateAccess(username);
        String refresh = generateRefresh(username);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userid(username)
                        .refreshToken(refresh)
                        .refreshExpiration(jwtProperties.getRefreshExp())
                        .build()
        );

        return new TokenResponse(access, refresh);
    }

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

    public String generateRefresh(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("type", "refresh")
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000)
                )
                .setIssuedAt(new Date())
                .compact();
    }
}
