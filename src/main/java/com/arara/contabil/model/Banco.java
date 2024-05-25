package com.arara.contabil.model;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Banco {

	@Id
	private String codigo;

	@Column(nullable = false, unique = true)
	private String nome;
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Banco [codigo=" + codigo + ", nome=" + nome + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
	}

}
