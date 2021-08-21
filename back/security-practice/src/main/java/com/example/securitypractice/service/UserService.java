package com.example.securitypractice.service;

import com.example.securitypractice.domain.Role;
import com.example.securitypractice.domain.UserEntity;
import com.example.securitypractice.dto.JoinForm;
import com.example.securitypractice.dto.LoginForm;
import com.example.securitypractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    public String join(JoinForm joinForm){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserEntity userEntity = UserEntity.builder()
                .username(joinForm.getUsername())
                .password(passwordEncoder.encode(joinForm.getPassword()))
                .build();
        userRepository.save(userEntity);
        return "join success";
    }

    @Transactional
    public String login(LoginForm loginForm){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String pw = userRepository.findByUsername(loginForm.getUsername())
                .orElseThrow(()->new UsernameNotFoundException(loginForm.getUsername())).getPassword();
        if(passwordEncoder.matches(loginForm.getPassword(), pw)) {

        } else{
            return "비밀번호가 일치하지 않습니다";
        }
        return "로그인 성공";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userWrapper = userRepository.findByUsername(username);

        UserEntity userEntity = userWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
            //롤을 부여하는 코드
        } else if(("manager").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.MANAGER.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }

        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
