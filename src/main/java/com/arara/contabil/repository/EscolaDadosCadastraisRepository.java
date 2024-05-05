package com.arara.contabil.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.contabil.model.EscolaDadosCadastrais;
import com.arara.contabil.model.Organization;

public interface EscolaDadosCadastraisRepository extends Repository<EscolaDadosCadastrais, Long> {

	EscolaDadosCadastrais save(EscolaDadosCadastrais escolaDadosCadastrais);

	Optional<EscolaDadosCadastrais> findByOrganizationId(Long organizationId);
	
	Optional<EscolaDadosCadastrais> findByOrganization(Organization organization);

}