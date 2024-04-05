package com.arara.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.security.model.Organization;
import com.arara.security.model.User;

public interface OrganizationRepository extends Repository<Organization, Long> {

	User save(Organization org);

	Optional<Organization> findById(Long id);

	Optional<Organization> findByCnpj(String cnpj);

	List<Organization> findAll();

}