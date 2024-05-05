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

@Entity
@EntityListeners(AuditingEntityListener.class)
public class EscolaDadosCadastrais {

	@Id
	private Long organizationId;
	
	@Column(nullable = false)
	private String unidadeExecutora;
	
	@Column(nullable = false)
	private String nomeEscola;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false)
	private String siglaEscola;

	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
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
