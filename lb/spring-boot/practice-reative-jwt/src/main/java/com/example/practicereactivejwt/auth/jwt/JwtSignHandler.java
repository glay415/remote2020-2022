package com.example.practicereactivejwt.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtSignHandler {

    public String createAccessToken(Integer userId) {
//        String type = typeO.orElse("accessToken");
        String type = "accessToken";
        Algorithm algorithm = Algorithm.HMAC256(JwtSecretKey.DEFAULT_SECRET);
        String token = JWT.create()
                .withClaim("type", type)
                .withClaim("userId", userId)
                .sign(algorithm);
        return token;
    }
}
