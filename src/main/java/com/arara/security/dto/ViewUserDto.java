package com.arara.security.dto;

import java.time.Instant;
import java.util.List;

import com.arara.security.model.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ViewUserDto implements Comparable<ViewUserDto> {
	private Long id;
	@Email(message = "Invalid Email.")
	@NotBlank(message = "A Email is required.")
	private String email;
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
	private List<ViewOrganizationDto> organizations;

	
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

	public List<ViewOrganizationDto> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<ViewOrganizationDto> organizations) {
		this.organizations = organizations;
	}
	
	@Override
	public String toString() {
		return "ViewUserDto [id=" + id + ", email=" + email + ", fullName=" + fullName + ", role=" + role + ", status="
				+ status + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt="
				+ createdAt + ", lastModifiedAt=" + lastModifiedAt + ", lastLoginAt=" + lastLoginAt + "]";
	}

	@Override
	public int compareTo(ViewUserDto o) {
		if (this.id < o.id) {
			return -1;
		}
		if (this.id > o.id) {
			return 1;
		}
		return 0;
	}


}