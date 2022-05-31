package com.example.xquareassignment.adapter.api.web;

import com.example.xquareassignment.application.auth.port.api.UserSignUpCommand;
import com.example.xquareassignment.application.auth.port.api.UserSignUpUseCase;
import com.example.xquareassignment.common.WebAdapter;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "/auth")
@RestController
@WebAdapter
class AuthController {

	private final UserSignUpUseCase userSignUpUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/user")
	void userSignUp(@RequestBody @Valid UserSignUpCommand userSignUpCommand) {
		userSignUpUseCase.signUp(userSignUpCommand);
	}
}
