package com.example.demo.payload;

import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import com.example.demo.auth.JwtTokenProvider;
import com.example.demo.auth.PrincipalDetails;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Data
public class LoginRequestDto {
    private String username;
    private String password;

    public String createToken(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider tokenProvider) {
        Optional<User> user = userRepository.findByUsername(this.username);
        if(!passwordEncoder.matches(this.password, user.get().getPassword())) {
            return "비번틀림";
        }
        return tokenProvider.createAccessToken(this.username);
    }
}
