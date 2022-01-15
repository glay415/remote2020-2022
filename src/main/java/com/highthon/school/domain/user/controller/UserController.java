package com.highthon.school.domain.user.controller;

import com.highthon.school.domain.user.dto.MyInformationResponseDto;
import com.highthon.school.domain.user.dto.SignInRequestDto;
import com.highthon.school.domain.user.dto.SignUpRequestDto;
import com.highthon.school.domain.user.dto.TokenResponseDto;
import com.highthon.school.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

	private final UserService userService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void signUp(@RequestBody SignUpRequestDto signUpRequest) {
		userService.singUp(signUpRequest);
	}

	@PutMapping
	public TokenResponseDto singIn(@RequestBody SignInRequestDto signInRequest) {
		return userService.singIn(signInRequest);
	}

	@GetMapping
	public MyInformationResponseDto myInformation() {
		return userService.myInformation();
	}
}
