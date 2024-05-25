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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "banco_id", "agencia", "contaCorrente" }) })
public class DomicilioBancario {

	@Id
	private Long id;

	@Column(nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "banco_id", nullable = false)
	private Banco banco;

	@Column(nullable = false)
	private String agencia;

	@Column(nullable = false)
	private String contaCorrente;

	private String cidade;

	private UF estado;
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
	
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name = "escola_programa_id")
	private EscolaPrograma escolaPrograma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getEstado() {
		return estado;
	}

	public void setEstado(UF estado) {
		this.estado = estado;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public EscolaPrograma getEscolaPrograma() {
		return escolaPrograma;
	}

	public void setEscolaPrograma(EscolaPrograma escolaPrograma) {
		this.escolaPrograma = escolaPrograma;
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
		DomicilioBancario other = (DomicilioBancario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DomicilioBancario [id=" + id + ", nome=" + nome + ", banco=" + banco + ", agencia=" + agencia
				+ ", contaCorrente=" + contaCorrente + ", cidade=" + cidade + ", estado=" + estado + ", createdBy="
				+ createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt=" + createdAt + ", lastModifiedAt="
				+ lastModifiedAt + "]";
	}

}
