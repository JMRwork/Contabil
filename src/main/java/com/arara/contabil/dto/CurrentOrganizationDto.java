package com.arara.contabil.dto;

public class CurrentOrganizationDto {

	private Long id;
	private String name;
	private String cnpj;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		return "CurrentOrganizationDto [id=" + id + ", name=" + name + ", cnpj=" + cnpj + "]";
	}

}
