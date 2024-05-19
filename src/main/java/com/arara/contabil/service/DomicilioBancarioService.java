package com.arara.contabil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.DomicilioBancario;
import com.arara.contabil.model.EscolaPrograma;
import com.arara.contabil.model.Organization;
import com.arara.contabil.repository.DomicilioBancarioRepository;

@Service
public class DomicilioBancarioService {
	Logger logger = LoggerFactory.getLogger(DomicilioBancarioService.class);

	@Autowired
	private DomicilioBancarioRepository domicilioBancarioRepository;

	public List<DomicilioBancario> listDomiciliosBancariosByOrganization(Organization organization) {
		return domicilioBancarioRepository.findAllByOrganization(organization);
	}
	
	public List<DomicilioBancario> listDomiciliosBancariosByOrganization(Long organizationId) {
		var organization = new Organization();
		organization.setId(organizationId);
		return domicilioBancarioRepository.findAllByOrganization(organization);
	}
	
	public List<DomicilioBancario> listDomiciliosBancariosByEscolaPrograma(EscolaPrograma ep) {
		return domicilioBancarioRepository.findAllByEscolaPrograma(ep);
	}
	
	public List<DomicilioBancario> listDomiciliosBancariosByEscolaPrograma(Long escolaProgramaId) {
		var ep = new EscolaPrograma();
		ep.setId(escolaProgramaId);
		return domicilioBancarioRepository.findAllByEscolaPrograma(ep);
	}

	public Optional<DomicilioBancario> findById(Long id) {
		return domicilioBancarioRepository.findById(id);
	}

	public DomicilioBancario saveBanco(DomicilioBancario domicilioBancario) {
		return domicilioBancarioRepository.save(domicilioBancario);
	}

}
