package com.highthon.school.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {

	private String id;
	private String password;
	private String nickname;

	public void newEncodePassword(String password) {
		this.password = password;
	}
}
