package com.example.xquareassignment.application.auth.service;

import com.example.xquareassignment.application.auth.port.api.UserSignUpCommand;
import com.example.xquareassignment.application.auth.port.api.UserSignUpUseCase;
import com.example.xquareassignment.application.auth.port.spi.SaveUserPort;
import com.example.xquareassignment.application.auth.port.spi.UserExistsByUsernamePort;
import com.example.xquareassignment.common.UseCase;
import com.example.xquareassignment.domain.auth.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
class UserSignUpService implements UserSignUpUseCase {

	private final SaveUserPort saveUserPort;
	private final UserExistsByUsernamePort userExistsPort;

	@Override
	public void signUp(UserSignUpCommand userSignUpCommand) {

		userExistsPort.isUserExists(userSignUpCommand.getUsername());
		User user = new User(userSignUpCommand.getUsername(), userSignUpCommand.getPassword());

		saveUserPort.saveUser(user);
	}
}
