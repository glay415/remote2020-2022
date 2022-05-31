package com.example.xquareassignment.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(length = 20, nullable = false)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(nullable = false)
	private Role role;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.role = Role.ROLE_USER;
	}
}
