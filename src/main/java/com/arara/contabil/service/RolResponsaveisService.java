package com.arara.contabil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.Organization;
import com.arara.contabil.model.RolResponsaveis;
import com.arara.contabil.repository.RolResponsaveisRepository;

@Service
public class RolResponsaveisService {

	Logger logger = LoggerFactory.getLogger(RolResponsaveisService.class);

	@Autowired
	private RolResponsaveisRepository rolResponsaveisRepository;

	public Optional<RolResponsaveis> findByCpf(String cpf) {
		return rolResponsaveisRepository.findByCpf(cpf);
	}
	
	public List<RolResponsaveis> findAllByOrganization(Organization organization) {
		return rolResponsaveisRepository.findAllByOrganizations(organization);
	}
	
	public List<RolResponsaveis> findAllByOrganization(Long organizationId) {
		var organization = new Organization();
		organization.setId(organizationId);
		return rolResponsaveisRepository.findAllByOrganizations(organization);
	}
}
