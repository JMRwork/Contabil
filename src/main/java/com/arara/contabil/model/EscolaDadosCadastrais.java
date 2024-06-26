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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "organizationId", "exercicio" }) })
public class EscolaDadosCadastrais {

	@Id
	private Long organizationId;
	
	@Column
	private String exercicio;
	
	@Column
	private String unidadeExecutora;
	
	@Column
	private String nomeEscola;
	
	@Column(length = 14, unique = true)
	private String cnpj;
	
	@Column
	private String siglaEscola;

	@Column
	private String endereco;
	
	@Column
	private String cidade;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@Column
	private String cep;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private String codigoInep;
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
    
    
    @OneToOne
    @JoinColumn(name="organization_id", nullable  = false)
    private Organization organization;


	public Long getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	

	public String getExercicio() {
		return exercicio;
	}


	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}


	public String getUnidadeExecutora() {
		return unidadeExecutora;
	}


	public void setUnidadeExecutora(String unidadeExecutora) {
		this.unidadeExecutora = unidadeExecutora;
	}


	public String getNomeEscola() {
		return nomeEscola;
	}


	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getSiglaEscola() {
		return siglaEscola;
	}


	public void setSiglaEscola(String siglaEscola) {
		this.siglaEscola = siglaEscola;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public UF getUf() {
		return uf;
	}


	public void setUf(UF uf) {
		this.uf = uf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCodigoInep() {
		return codigoInep;
	}


	public void setCodigoInep(String codigoInep) {
		this.codigoInep = codigoInep;
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


	@Override
	public int hashCode() {
		return Objects.hash(organizationId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EscolaDadosCadastrais other = (EscolaDadosCadastrais) obj;
		return Objects.equals(organizationId, other.organizationId);
	}


	@Override
	public String toString() {
		return "EscolaDadosCadastrais [organizationId=" + organizationId + ", unidadeExecutora=" + unidadeExecutora
				+ ", nomeEscola=" + nomeEscola + ", cnpj=" + cnpj + ", siglaEscola=" + siglaEscola + ", endereco="
				+ endereco + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone
				+ ", email=" + email + ", codigoInep=" + codigoInep + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + ", createdAt=" + createdAt + ", lastModifiedAt=" + lastModifiedAt + "]";
	} 
    
    
}
