package com.example.practicereactivejwt.auth.bearer;

import com.example.practicereactivejwt.auth.jwt.AuthorizationHeaderPayload;
import com.example.practicereactivejwt.auth.jwt.CurrentUserAuthenticationBearer;
import com.example.practicereactivejwt.auth.jwt.JwtVerifyHandler;
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Predicate;

public class ServerHttpBearerAuthenticationConverter implements Function<ServerWebExchange, Mono<Authentication>> {

    private static final String BEARER = "Bearer ";
    private static final Predicate<String> matchBearerLength = authValue -> authValue.length() > BEARER.length();
    private static final Function<String, Mono<String>> isolateBearerValue = authValue -> Mono.justOrEmpty(authValue.substring(BEARER.length()));

    private final JwtVerifyHandler jwtVerifier = new JwtVerifyHandler();

    @Override
    public Mono<Authentication> apply(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange)
                .flatMap(AuthorizationHeaderPayload::extract)
                .filter(matchBearerLength)
                .flatMap(isolateBearerValue)
                .flatMap(jwtVerifier::check)
                .flatMap(CurrentUserAuthenticationBearer::create).log();
    }
}
