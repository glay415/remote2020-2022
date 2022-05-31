package com.example.xquareassignment.application.auth.port.spi;

import com.example.xquareassignment.domain.auth.User;

public interface SaveUserPort {
	void saveUser(User user);
}
