package com.arara.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangeUserPasswordDto {
	private Long id;
	@NotBlank(message = "A password is needed.")
	@Size(min = 6, message = "Password need at least 6 character.")
	private String password;
	@NotBlank(message = "A password is needed.")
	@Size(min = 6, message = "Password need at least 6 character.")
	private String repeatPassword;

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ChangeUserPasswordDto [id=" + id + "]";
	}


}
