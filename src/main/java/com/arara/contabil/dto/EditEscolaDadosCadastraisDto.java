package com.arara.contabil.dto;

import com.arara.contabil.model.UF;

import jakarta.validation.constraints.NotBlank;

public class EditEscolaDadosCadastraisDto {

	private Long organizationId;
	
	@NotBlank(message = "O ano do exercício da Escola é necessario.")
	private String exercicio;
	@NotBlank(message = "O nome da Unidade Executora da Escola é necessario.")
	private String unidadeExecutora;
	@NotBlank(message = "O nome da Escola é necessario.")
	private String nomeEscola;
	@NotBlank(message = "O Cnpj da Escola é necessario.")
	private String cnpj;
	@NotBlank(message = "A sigla da Escola é necessaria.")
	private String siglaEscola;
	@NotBlank(message = "O Endereço da Escola é necessario.")
	private String endereco;
	@NotBlank(message = "O nome da cidade da Escola é necessario.")
	private String cidade;
	private UF uf;
	@NotBlank(message = "O CEP da Escola é necessario.")
	private String cep;
	@NotBlank(message = "O Telefone da Escola é necessario.")
	private String telefone;
	@NotBlank(message = "O Email da Escola é necessario.")
	private String email;
	@NotBlank(message = "O Código do Inep da Escola é necessario.")
	private String codigoInep;
	
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
	@Override
	public String toString() {
		return "EditEscolaDadosCadastraisDto [organizationId=" + organizationId + ", exercicio=" + exercicio
				+ ", unidadeExecutora=" + unidadeExecutora + ", nomeEscola=" + nomeEscola + ", cnpj=" + cnpj
				+ ", siglaEscola=" + siglaEscola + ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf
				+ ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + ", codigoInep=" + codigoInep + "]";
	}


}