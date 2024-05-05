package com.arara.contabil.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserDto {
	@Email(message = "Invalid Email.")
	@NotBlank(message = "A Email is required.")
	private String email;
	@NotBlank(message = "A password is needed.")
	@Size(min = 6, message = "Password need at least 6 character.")
	private String password;
	@NotBlank(message = "A Full Name is required.")
	@Size(min = 3, max = 60, message = "A Name must have between 3 and 60 characters.")
	private String fullName;
	private String role;

	public NewUserDto() {
		super();
	}
	
	public NewUserDto(String email, String password, String fullName, String role) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "NewUserDto [email=" + email + ", password=" + password + ", fullName=" + fullName + ", role=" + role + "]";
	}
}
