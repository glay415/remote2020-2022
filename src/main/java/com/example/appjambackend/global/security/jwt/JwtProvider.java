package com.example.appjambackend.global.security.jwt;

import com.example.appjambackend.domain.user.entity.refresh.RefreshToken;
import com.example.appjambackend.domain.user.entity.refresh.RefreshTokenRepository;
import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjambackend.global.security.details.CustomUserDetailsService;
import com.example.appjambackend.global.security.exception.ExpiredTokenException;
import com.example.appjambackend.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CustomUserDetailsService userDetailsService;

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

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if(bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > 7) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        Claims body = getBody(token);

        if(body.getExpiration().before(new Date())) {
            throw ExpiredTokenException.EXCEPTION;
        }

        UserDetails userDetails = getDetails(body);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (MalformedJwtException | SignatureException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private UserDetails getDetails(Claims body) {
        return userDetailsService.loadUserByUsername(body.getSubject());
    }
}
