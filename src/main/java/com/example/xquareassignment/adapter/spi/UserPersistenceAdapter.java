package com.example.xquareassignment.adapter.spi;

import com.example.xquareassignment.application.exception.UserAlreadyExistException;
import com.example.xquareassignment.application.auth.port.spi.SaveUserPort;
import com.example.xquareassignment.application.auth.port.spi.UserExistsByUsernamePort;
import com.example.xquareassignment.common.PersistenceAdapter;
import com.example.xquareassignment.domain.auth.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements SaveUserPort, UserExistsByUsernamePort {

	private final SpringDataUserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void isUserExists(String username) {
		if (userRepository.findByUsername(username).isPresent()) {
			throw UserAlreadyExistException.EXCEPTION;
		}
	}
}
