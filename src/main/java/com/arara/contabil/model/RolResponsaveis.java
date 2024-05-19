package com.arara.contabil.model;

import java.time.Instant;
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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="responsaveis")
@EntityListeners(AuditingEntityListener.class)
public class RolResponsaveis {
	@Id
	private String cpf;
	
	@Column
	private String nome;
	
	@Column
	private String funcao;
	
	@Column
	private String rg;
	
	@Column
	private String orgaoEmissor;
	
	@Column
	private String periodoGestao;
	
	@Column
	private String ataNomeacao;
	
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
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
	
	@ManyToMany
	@JoinTable(
			name = "responsaveis_organizations",
			joinColumns = @JoinColumn(name = "responsavel_id"),
			inverseJoinColumns = @JoinColumn(name = "organization_id"))
	Set<Organization> organizations;
	
	public Set<Organization> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
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
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolResponsaveis other = (RolResponsaveis) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	@Override
	public String toString() {
		return "RolResponsaveis [cpf=" + cpf + ", nome=" + nome + ", funcao=" + funcao + ", rg=" + rg
				+ ", orgaoEmissor=" + orgaoEmissor + ", periodoGestao=" + periodoGestao + ", ataNomeacao=" + ataNomeacao
				+ ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone="
				+ telefone + ", email=" + email + ", Organizations=" + organizations + "]";
	}	
}