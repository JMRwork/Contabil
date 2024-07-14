package com.arara.contabil.dto;

import java.util.Objects;

import com.arara.contabil.model.UF;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EditRolResponsaveisDto{
	@NotBlank(message = "O CPF não pode ser nulo.")
	@Size(min = 11, max = 11, message = "O CPF deve possuir 11 digitos.")
	private String cpf;
	@NotBlank(message = "O nome não pode ser nulo.")
	@Size(min = 3, max = 60, message = "O nome deve possuir de 3 a 60 caracteres.")
	private String nome;
	@NotBlank(message = "O rg não pode ser nulo.")
	@Size(min = 9, max = 10, message = "O rg deve possuir de 9 a 10 digitos.")
	private String rg;
	@NotBlank(message = "O orgão emissor não pode ser nulo.")
	private String orgaoEmissor;
	@NotBlank(message = "O endereço não pode ser nulo.")
	private String endereco;
	@NotBlank(message = "A cidade não pode ser nula.")
	private String cidade;
	@Enumerated(EnumType.STRING)
	private UF uf;
	@NotBlank(message = "O CEP não pode ser nulo.")
	@Size(min = 11, max = 11, message = "O CEP deve possuir 11 digitos.")
	private String cep;
	@NotBlank(message = "O telefone não pode ser nulo.")
	@Size(min = 11, max = 13, message = "O telefone deve possuir entre 8 e 13 digitos.")
	private String telefone;
	
	@Email
	@NotBlank(message = "O Email não pode ser nulo.")
	private String email;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	@Override
	public int hashCode() {
		return Objects.hash(cep);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditRolResponsaveisDto other = (EditRolResponsaveisDto) obj;
		return Objects.equals(cep, other.cep);
	}
	@Override
	public String toString() {
		return "EditRolResponsaveisDto [cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", orgaoEmissor=" + orgaoEmissor
				+ ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone="
				+ telefone + ", email=" + email + "]";
	}
	
	
	
}