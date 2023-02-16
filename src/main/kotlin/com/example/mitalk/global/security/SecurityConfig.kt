package com.example.mitalk.global.security

import com.example.mitalk.domain.auth.domain.Role
import com.example.mitalk.global.security.filter.FilterConfig
import com.example.mitalk.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils


@Configuration
class SecurityConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper,
) {
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .cors().and()
                .csrf().disable()
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)


        http
                .authorizeRequests()
                .requestMatchers(RequestMatcher { request ->
                    CorsUtils.isPreFlightRequest(request)
                }).permitAll()

                // file
                .antMatchers(HttpMethod.POST, "/file").authenticated()

                // customer
                .antMatchers(HttpMethod.GET, "/customer/question").permitAll()
                .antMatchers(HttpMethod.GET, "/customer/review").hasAuthority(Role.CUSTOMER.name)
                .antMatchers(HttpMethod.POST, "/customer/signin").permitAll()
                .antMatchers(HttpMethod.POST, "/customer/review").hasAuthority(Role.CUSTOMER.name)

                // counsellor
                .antMatchers(HttpMethod.POST, "/counsellor/activity").hasAuthority(Role.COUNSELLOR.name)

                // admin
                .antMatchers(HttpMethod.GET, "/admin/counsellor").authenticated()
                .antMatchers(HttpMethod.POST, "/admin/counsellor").authenticated()

                // auth
                .antMatchers(HttpMethod.GET, "/auth/hello").hasAuthority(Role.COUNSELLOR.name)
                .antMatchers(HttpMethod.POST, "/auth/signin").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
                .antMatchers(HttpMethod.DELETE, "/auth").authenticated()

                // ws
                .antMatchers("/ws/chat").permitAll()
                .anyRequest().denyAll()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

                .and()
                .apply(FilterConfig(jwtTokenProvider, objectMapper))
        return http.build()
    }

}