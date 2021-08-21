package com.example.securitypractice.config;

import com.example.securitypractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity //시큐리티 설정 클래스 정의
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //WebSecurityConfigurer 인스턴스를 편리하게 생성하기 위한 클래스
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        //BCryptPasswordEncoder는 시큐리티에서 제공하는 비밀번호 암호화 객체
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //시큐리티에서 에서 모든 인증은 AuthenticationManager를 통해 이루어지며 AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용
        //로그인 처리 즉, 인증을 위해서는 UserDetailService를 통해서 필요한 정보들을 가져옴
        //실제 인증을 진행할 Provider (DB로 부터 유저체크)
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        //WebSecurity는 FilterChainProxy를 생성하는 필터
        //이미지,자바스크립트,css 디렉토리 보안 설정 (접근 처리)
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**");
        //해당 경로의 파일들은 Spring 시큐리티가 무시할 수 있도록 설정
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //HttpSecurity를 통해 HTTP 요청에 대한 웹 기반 보안을 구성 가능
        //HTTP 관련 보안 설정 **가장 중요 ( URL 별 권한 설정)
          http.csrf().disable();
//        http.httpBasic().disable();
        http.authorizeRequests()
                //HttpServletRequest에 따라 접근(access)을 제한
                .antMatchers("/user/**").authenticated()
                .antMatchers("/manager/**").hasRole("ADMIN or MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                //form 기반으로 인증을 함, 로그인 정보는 기본적으로 HttpSession을 이용
//                .loginPage("/member/login") //커스텀 loginForm
//                .defaultSuccessUrl("/member/login/result") //성공 페이지, 컨트롤러에 URL 매핑 필요
//                .permitAll()
                .and()
                .logout()
                //로그아웃을 지원하는 메서드이며, WebSecurityConfigurerAdapter를 사용할 때 자동으로 적용됨
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) //커스텀 logout
                .logoutSuccessUrl("/member/logout/result")
                .invalidateHttpSession(true) //HTTP 세션 초기화
                //.deleteCookies("KEY명") 로그아웃시 특정쿠키 제거
                .and()
                .exceptionHandling().accessDeniedPage("/member/denied");
                //예외가 발생했을 때 exceptionHandling() 메서드로 핸들링할 수 있음
    }
}
