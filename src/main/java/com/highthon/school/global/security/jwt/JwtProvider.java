package com.highthon.school.global.security.jwt;

import com.highthon.school.domain.user.dto.TokenResponseDto;
import com.highthon.school.global.exception.ExpiredTokenException;
import com.highthon.school.global.exception.InvalidTokenException;
import com.highthon.school.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtProvider {

	private final JwtProperties jwtProperties;
	private final AuthDetailsService authDetailsService;

	public TokenResponseDto generateToken(String id) {
		String token = Jwts.builder()
			.setSubject(id)
			.signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
			.setExpiration(
				new Date(System.currentTimeMillis() + jwtProperties.getAccessExp())
			)
			.setIssuedAt(new Date())
			.compact();

		return new TokenResponseDto(token);
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
			throw new ExpiredTokenException();
		}

		UserDetails userDetails = authDetailsService.loadUserByUsername(body.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private Claims getBody(String token) {
		try {
			return Jwts.parser()
				.setSigningKey(jwtProperties.getSecretKey())
				.parseClaimsJws(token)
				.getBody();
		} catch (ExpiredJwtException e) {
			throw new ExpiredTokenException();
		} catch (MalformedJwtException | SignatureException e) {
			throw new InvalidTokenException();
		}
	}

}
