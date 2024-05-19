package com.arara.contabil.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="organizations")
@EntityListeners(AuditingEntityListener.class)
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String legalName;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cnpj;
	
	@Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive;
    
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
    
    private Instant deletedAt;
    
    @ManyToMany(mappedBy = "organizations")
    Set<User> users;
    
    @OneToMany(mappedBy = "organization")
    private List<Movimento> movimento;
    
    @OneToMany(mappedBy = "organization")
    private List<DomicilioBancario> domiciolioBancarios;

    @ManyToMany(mappedBy = "organizations")
    Set<RolResponsaveis> responsaveis;
    
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<RolResponsaveis> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(Set<RolResponsaveis> responsaveis) {
		this.responsaveis = responsaveis;
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
		Organization other = (Organization) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", legalName=" + legalName + ", cnpj=" + cnpj
				+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + ", deletedAt=" + deletedAt + "]";
	}
	
}
