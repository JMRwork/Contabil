package com.arara.contabil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewOrganizationDto {

	@NotBlank(message = "O nome é obrigatório.")
	private String name;
	
	private String legalName;

	@NotBlank(message = "Cnpj é obrigatório.")
	@Size(min = 14, max = 14, message = "Cnpj deve ter 14 caracteres.") 
	private String cnpj;
	private Boolean isActive;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "EditOrganizationDto [name=" + name + ", legalName=" + legalName + ", cnpj=" + cnpj
				+ ", isActive=" + isActive + "]";
	}

}
