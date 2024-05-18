package com.arara.contabil.model;

import java.time.Instant;
import java.util.List;
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

@Entity
@EntityListeners(AuditingEntityListener.class)

public class EscolaPrograma {
	@Id
	private Long programaId;
	
	@Column
	private String nomePrograma;
	
	@Column
	private String origemRecursos;
	
	@Column
	private Integer exercicio;
	
	@Column
	private Integer numOficioEncaminhamento;
	
	@Column
	private Integer numConvenio;
	
	@Column
	private String banco;
	
	@Column
	private String agencia;
	
	@Column
	private List<String> numConta;
	
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
    @JoinColumn(name="organization_id", nullable = false)
    private Organization organization;

	public Long getProgramaId() {
		return programaId;
	}

	public void setProgramaId(Long programaId) {
		this.programaId = programaId;
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

	public Integer getExercicio() {
		return exercicio;
	}

	public void setExercicio(Integer exercicio) {
		this.exercicio = exercicio;
	}

	public Integer getNumOficioEncaminhamento() {
		return numOficioEncaminhamento;
	}

	public void setNumOficioEncaminhamento(Integer numOficioEncaminhamento) {
		this.numOficioEncaminhamento = numOficioEncaminhamento;
	}

	public Integer getNumConvenio() {
		return numConvenio;
	}

	public void setNumConvenio(Integer numConvenio) {
		this.numConvenio = numConvenio;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public List<String> getNumConta() {
		return numConta;
	}

	public void setNumConta(List<String> numConta) {
		this.numConta = numConta;
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

	public Organization getOrganization() {
		return organization;
	}

	@Override
	public int hashCode() {
		return Objects.hash(programaId);
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
		return Objects.equals(programaId, other.programaId);
	}

	@Override
	public String toString() {
		return "EscolaPrograma [programaId=" + programaId + ", nomePrograma=" + nomePrograma + ", origemRecursos="
				+ origemRecursos + ", exercicio=" + exercicio + ", numOficioEncaminhamento=" + numOficioEncaminhamento
				+ ", numConvenio=" + numConvenio + ", banco=" + banco + ", agencia=" + agencia + ", numConta="
				+ numConta + ", cidade=" + cidade + ", nomeSecretarioEdu=" + nomeSecretarioEdu + ", createdBy="
				+ createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt=" + createdAt + ", lastModifiedAt="
				+ lastModifiedAt + ", organization=" + organization + "]";
	}
    
    
}