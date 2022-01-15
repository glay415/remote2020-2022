package com.highthon.school.domain.user.service;

import com.highthon.school.domain.user.User;
import com.highthon.school.domain.user.dto.SignInRequestDto;
import com.highthon.school.domain.user.dto.SignUpRequestDto;
import com.highthon.school.domain.user.dto.TokenResponseDto;
import com.highthon.school.domain.user.exception.UserAlreadyExistException;
import com.highthon.school.domain.user.repository.UserRepository;
import com.highthon.school.global.exception.UserNotFoundException;
import com.highthon.school.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;

	public void singUp(SignUpRequestDto signUpRequest) {
		if(userRepository.existsById(signUpRequest.getId())) throw new UserAlreadyExistException();
		signUpRequest.newEncodePassword(passwordEncoder.encode(signUpRequest.getPassword()));
		userRepository.save(new User(signUpRequest));
	}

	public TokenResponseDto singIn(SignInRequestDto signInRequest) {
		return userRepository.findById(signInRequest.getId())
			.filter(user -> passwordEncoder.matches(signInRequest.getPassword(), user.getPassword()))
			.map(user -> jwtProvider.generateToken(user.getId()))
			.orElseThrow(UserNotFoundException::new);
	}
}
