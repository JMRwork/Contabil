package com.arara.contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.contabil.model.Organization;
import com.arara.contabil.model.RolResponsaveis;

public interface RolResponsaveisRepository extends Repository<RolResponsaveis, String> {

	RolResponsaveis save(RolResponsaveis rolResponsaveis);

	Optional<RolResponsaveis> findByCpf(String cpf);
	
	List<RolResponsaveis> findAllByOrganizations(Organization organization);

}