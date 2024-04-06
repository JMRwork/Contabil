package com.arara.security.model;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String password;
	private String fullName;
	private String role;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
	@CreatedBy
	private Long createdBy;
	
    @LastModifiedBy
    private Long lastModifiedBy;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
    
    private Instant lastLoginAt;
    
    @ManyToMany
    @JoinTable(
    		name = "users_organizations",
    		joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "organization_id"))
    Set<Organization> organizations;

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

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getLastModifiedAt() {
		return lastModifiedAt;
	}

	public Instant getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Instant lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullName=" + fullName + ", role=" + role + ", status="
				+ status + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt="
				+ createdAt + ", lastModifiedAt=" + lastModifiedAt + ", lastLoginAt=" + lastLoginAt + "]";
	}

}
