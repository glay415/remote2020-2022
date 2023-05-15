package com.example.practicereactivejwt.auth.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class CurrentUserAuthenticationToken extends AbstractAuthenticationToken {

    private final String tokenType;
    private final Integer userId;
    private final DecodedJWT decodedJwtToken;

    @Override
    public Object getCredentials() {
        return this.decodedJwtToken;
    }

    @Override
    public Object getPrincipal() {
        return this.userId;
    }

    public CurrentUserAuthenticationToken(String tokenType, Integer userId, DecodedJWT decodedJwtToken) {
        super(null);
        this.tokenType = tokenType;
        this.userId = userId;
        this.decodedJwtToken = decodedJwtToken;
        super.setAuthenticated(true);
    }
}
