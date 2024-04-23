package com.arara.security.dto;

import java.time.Instant;
import java.util.Set;

public class ViewOrganizationDto {

	private Long id;
	private String name;
	private String legalName;
	private String cnpj;
	private Boolean isActive;
	private Long createdBy;
	private Long lastModifiedBy;
    private Instant createdAt;
    private Instant lastModifiedAt;
    private Instant deletedAt;
    Set<ViewUserDto> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getCreatedBy() {
		return createdBy;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getLastModifiedAt() {
		return lastModifiedAt;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Set<ViewUserDto> getUsers() {
		return users;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public void setLastModifiedAt(Instant lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public void setUsers(Set<ViewUserDto> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", legalName=" + legalName + ", cnpj=" + cnpj
				+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + ", deletedAt=" + deletedAt + "]";
	}
	
}
