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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nomePrograma", "exercicio", "organization" }) })
public class EscolaPrograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nomePrograma;

	@Column
	private String origemRecursos;

	@Column(nullable = false)
	private String exercicio;

	@Column
	private String numOficioEncaminhamento;

	@Column
	private String numConvenio;

	@Column
	private String cidade;

	@Column
	private String nomeSecretarioEdu;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public String getOrigemRecursos() {
		return origemRecursos;
	}

	public void setOrigemRecursos(String origemRecursos) {
		this.origemRecursos = origemRecursos;
	}

	public String getExercicio() {
		return exercicio;
	}

	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}

	public String getNumOficioEncaminhamento() {
		return numOficioEncaminhamento;
	}

	public void setNumOficioEncaminhamento(String numOficioEncaminhamento) {
		this.numOficioEncaminhamento = numOficioEncaminhamento;
	}

	public String getNumConvenio() {
		return numConvenio;
	}

	public void setNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNomeSecretarioEdu() {
		return nomeSecretarioEdu;
	}

	public void setNomeSecretarioEdu(String nomeSecretarioEdu) {
		this.nomeSecretarioEdu = nomeSecretarioEdu;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
		EscolaPrograma other = (EscolaPrograma) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EscolaPrograma [id=" + id + ", nomePrograma=" + nomePrograma + ", origemRecursos=" + origemRecursos
				+ ", exercicio=" + exercicio + ", numOficioEncaminhamento=" + numOficioEncaminhamento + ", numConvenio="
				+ numConvenio + ", cidade=" + cidade + ", nomeSecretarioEdu=" + nomeSecretarioEdu + ", createdBy="
				+ createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt=" + createdAt + ", lastModifiedAt="
				+ lastModifiedAt + "]";
	}

}