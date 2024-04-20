package com.arara.security.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.security.model.Organization;
import com.arara.security.repository.OrganizationRepository;

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
}
