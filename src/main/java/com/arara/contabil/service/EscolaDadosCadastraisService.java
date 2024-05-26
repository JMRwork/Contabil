package com.arara.contabil.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.EscolaDadosCadastrais;
import com.arara.contabil.model.Organization;
import com.arara.contabil.model.User;
import com.arara.contabil.model.UserStatus;
import com.arara.contabil.repository.EscolaDadosCadastraisRepository;

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
	
//	public Boolean createDadosCadastrais(EscolaDadosCadastrais escolaDadosCadastrais) {
//		try { 
//			escolaDadosCadastraisRepository.save(escolaDadosCadastrais);
//			return true;
//		} catch (Exception e) {
//			logger.error("Erro ao criar Dados Cadastrais", e);
//			return false;
//		}
//	}

	public Boolean updateEscolaDadosCadastrais(EscolaDadosCadastrais escolaDadosCadastrais) {
		escolaDadosCadastraisRepository.save(escolaDadosCadastrais);
		return true;
	}
}
