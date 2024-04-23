package com.arara.security.dto;

import java.util.Set;

import com.arara.security.model.UserStatus;
import com.arara.security.model.Organization;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EditUserDto {
	private Long id;
	@Email(message = "Invalid Email.")
	@NotBlank(message = "A Email is required.")
	private String email;
	@NotBlank(message = "A Full Name is required.")
	@Size(min = 3, max = 60, message = "A Name must have between 3 and 60 characters.")
	private String fullName;
	private String role;
	private UserStatus status;	
	private Set<Organization> organizations;

	
	public EditUserDto() {
		super();
	}
	
	public EditUserDto(String email, String password, String fullName, String role) {
		this.email = email;
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

	@Override
	public String toString() {
		return "EditUserDto [id=" + id + ", email=" + email + ", fullName=" + fullName + ", role=" + role + ", status="
				+ status + ", organizations=" + organizations + "]";
	}

	public Set<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}

}
