package com.arara.contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.contabil.model.Organization;

public interface OrganizationRepository extends Repository<Organization, Long> {

	Organization save(Organization org);

	Optional<Organization> findById(Long id);

	Optional<Organization> findByCnpj(String cnpj);

	List<Organization> findAll();
	
	List<Organization> findAllByIsActiveTrue();
	
	List<Organization> findAllByIdIn(List<Long> organizationIds);
	
	List<Organization> findAllByIdInAndIsActiveTrue(List<Long> organizationIds);

}