package com.highthon.school.domain.user.facade;

import com.highthon.school.domain.user.User;
import com.highthon.school.domain.user.exception.CredentialsNotFoundException;
import com.highthon.school.domain.user.repository.UserRepository;
import com.highthon.school.global.exception.UserNotFoundException;
import com.highthon.school.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

	private final UserRepository userRepository;

	public AuthDetails getCurrentDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(principal instanceof AuthDetails)) {
			throw new CredentialsNotFoundException();
		}
		return (AuthDetails) principal;
	}

	public User getCurrentUser() {
		return userRepository.findById(getCurrentDetails().getUsername())
			.orElseThrow(UserNotFoundException::new);
	}
}
