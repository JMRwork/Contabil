package com.arara.security.dto;

import java.time.Instant;

import com.arara.security.model.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	private Long id;
	@Email(message = "Invalid Email.")
	@NotBlank(message = "A Email is required.")
	private String email;
	@NotBlank(message = "A password is needed.")
	@Min(value = 6, message = "Password need at least 6 character.")
	private String password;
	@NotBlank(message = "A Full Name is required.")
	@Size(min = 3, max = 60, message = "A Name must have between 3 and 60 characters.")
	private String fullName;
	private String role;
	private UserStatus status;
	private Long createdBy;
	private Long lastModifiedBy;
	private Instant createdAt;
	private Instant lastModifiedAt;
	private Instant lastLoginAt;

	
	public UserDto() {
		super();
	}
	
	public UserDto(String email, String password, String fullName, String role) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Instant lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public Instant getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Instant lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", password=" + password + ", fullName=" + fullName + ", role=" + role + "]";
	}

}
