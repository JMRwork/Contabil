package com.arara.security.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.security.model.EscolaDadosCadastrais;
import com.arara.security.model.Organization;

public interface EscolaDadosCadastraisRepository extends Repository<EscolaDadosCadastrais, Long> {

	EscolaDadosCadastrais save(EscolaDadosCadastrais escolaDadosCadastrais);

	Optional<EscolaDadosCadastrais> findByOrganizationId(Long organizationId);
	
	Optional<EscolaDadosCadastrais> findByOrganization(Organization organization);

}