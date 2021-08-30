package com.example.demo.auth;

import com.example.demo.User.UserRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final UserRepository userRepository;
//
//    @Value("${jwt.exp.access}")
//    private Long accessTokenExpiration;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${jwt.header}")
    private String header;

    protected String init() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createAccessToken(String username) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("aud", username);

        Date now = new Date();
        payloads.put("iat", now);
        payloads.put("exp", new Date(now.getTime() + 1000 * 60 * 60 * 24));

        return Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(SignatureAlgorithm.HS256, init())
                .compact();
    }

    public boolean validatedToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !getUser(token)
                    .getExpiration()
                    .before(new Date());
        } catch (MalformedJwtException e) {
            //log.info("잘못된 JWT 서명입니다.");

        } catch (ExpiredJwtException e) {
            //log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            //log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            //log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    public Claims getUser(String token) {
        return Jwts.parser().setSigningKey(init()).parseClaimsJws(token).getBody();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userRepository.findByUsername(this.getUser(token).getSubject())
                .map(PrincipalDetails::new)
                .orElseThrow();
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader(header);

        if (StringUtils.hasText(token) && token.startsWith(prefix)) {
            return token.substring(7);
        }
        return null;
    }
}
