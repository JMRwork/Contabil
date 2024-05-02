package com.arara.security.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.security.model.EscolaDadosCadastrais;
import com.arara.security.model.Organization;
import com.arara.security.repository.EscolaDadosCadastraisRepository;

@Service
public class EscolaDadosCadastraisService {

	Logger logger = LoggerFactory.getLogger(EscolaDadosCadastraisService.class);

	@Autowired
	private EscolaDadosCadastraisRepository escolaDadosCadastraisRepository;

	public Optional<EscolaDadosCadastrais> findByOrg(Organization org) {
		return escolaDadosCadastraisRepository.findByOrganization(org);
	}
	
	public Optional<EscolaDadosCadastrais> findById(Long organizationId) {
		return escolaDadosCadastraisRepository.findByOrganizationId(organizationId);
	}
}
