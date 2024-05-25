package com.arara.contabil.model;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class FuncaoResponsaveis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	RolResponsaveis responsavel;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	Organization organization;

	private String funcao;

	private String periodoGestao;

	private String ataNomeacao;
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolResponsaveis getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(RolResponsaveis responsavel) {
		this.responsavel = responsavel;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getPeriodoGestao() {
		return periodoGestao;
	}

	public void setPeriodoGestao(String periodoGestao) {
		this.periodoGestao = periodoGestao;
	}

	public String getAtaNomeacao() {
		return ataNomeacao;
	}

	public void setAtaNomeacao(String ataNomeacao) {
		this.ataNomeacao = ataNomeacao;
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
		FuncaoResponsaveis other = (FuncaoResponsaveis) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "FuncaoResponsaveis [id=" + id + ", funcao=" + funcao + ", periodoGestao=" + periodoGestao
				+ ", ataNomeacao=" + ataNomeacao + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
				+ ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
	}
    
    
}