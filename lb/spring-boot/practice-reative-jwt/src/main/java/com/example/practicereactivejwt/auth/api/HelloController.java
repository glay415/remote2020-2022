package com.example.practicereactivejwt.auth.api;

import com.example.practicereactivejwt.auth.api.dto.HelloUser;
import com.example.practicereactivejwt.auth.jwt.JwtSignHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final Mono<SecurityContext> context  = ReactiveSecurityContextHolder.getContext();
    private final JwtSignHandler jwtSignHandler;

    private Mono<Integer> extractUserSeqIdFromJwtToken(Mono<SecurityContext> context) {
        return context.filter(c -> Objects.nonNull(c.getAuthentication()))
                .map(s -> s.getAuthentication().getPrincipal())
                .cast(Integer.class);
    }

    @GetMapping("/v1/hello")
    public Mono<HelloUser> getHello() {
        return extractUserSeqIdFromJwtToken(context).flatMap(userId -> Mono.just(new HelloUser(userId)));
    }

    @PostMapping("/v1/users/login")
    public String login(@RequestParam Integer userId) {
        return jwtSignHandler.createAccessToken( userId);
    }
}
