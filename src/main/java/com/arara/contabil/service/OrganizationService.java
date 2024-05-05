package com.arara.contabil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.Organization;
import com.arara.contabil.repository.OrganizationRepository;

@Service
public class OrganizationService {

	Logger logger = LoggerFactory.getLogger(OrganizationService.class);

	@Autowired
	private OrganizationRepository organizationRepository;

	public List<Organization> listOrganizations() {
		return organizationRepository.findAll();
	}
	
	public Optional<Organization> findById(long id) {
		return organizationRepository.findById(id);
	}
	
	public Boolean updateOrganization(Organization org){
		Optional<Organization> result = organizationRepository.findByCnpj(org.getCnpj());
		if (result.isPresent() && result.get().getId() != org.getId()) {
			return false;
		}
		organizationRepository.save(org);
		return true;
		// Revisar
	}
	
	public Boolean createOrganization(Organization org) {
		Optional<Organization> result = organizationRepository.findByCnpj(org.getCnpj());
		if (result.isEmpty()) {
			organizationRepository.save(org);
			logger.info("Organization " + org.getCnpj() +" created");
			return true;
		} else {
			logger.info("this organization "+ org.getCnpj() +" already exists");
			return false;
		}	
	} 
}
