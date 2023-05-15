package com.example.practicereactivejwt;

import com.example.practicereactivejwt.auth.bearer.BearerTokenReactiveAuthenticationManager;
import com.example.practicereactivejwt.auth.bearer.ServerHttpBearerAuthenticationConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@SpringBootApplication
public class PracticeReactiveJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeReactiveJwtApplication.class, args);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        //Disable things you don't need in spring security.
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        //Those that do not require jwt token authentication should be pass.
        http.authorizeExchange().pathMatchers("/", "/v1/users/signUp", "/v1/users/login").permitAll();
        http.authorizeExchange().pathMatchers(HttpMethod.OPTIONS).permitAll();
        http.authorizeExchange().pathMatchers(HttpMethod.GET).permitAll();
        http.authorizeExchange().pathMatchers(HttpMethod.POST).permitAll();

        //Apply a JWT custom filter to all / ** apis.
        http.authorizeExchange()
                .pathMatchers("/**")
                .authenticated()
                .and()
                .addFilterAt(bearerAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .logout().disable()
                .cors();

        return http.build();
    }

    private AuthenticationWebFilter bearerAuthenticationFilter() {
        AuthenticationWebFilter bearerAuthenticationFilter;

        Function<ServerWebExchange, Mono<Authentication>> bearerConverter;

        ReactiveAuthenticationManager authManger;
        authManger = new BearerTokenReactiveAuthenticationManager();
        bearerAuthenticationFilter = new AuthenticationWebFilter(authManger);
        bearerConverter = new ServerHttpBearerAuthenticationConverter();

        bearerAuthenticationFilter.setAuthenticationConverter(bearerConverter);
        bearerAuthenticationFilter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers("/**"));

        return bearerAuthenticationFilter;
    }
}
