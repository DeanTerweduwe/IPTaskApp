package com.example.demo.dto;

import com.example.demo.Domain.UserRole;

import javax.validation.constraints.NotEmpty;

public class CreateUserDTO {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private UserRole role;
	public CreateUserDTO() {

	}
	public CreateUserDTO(@NotEmpty String username, @NotEmpty String password, UserRole role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
