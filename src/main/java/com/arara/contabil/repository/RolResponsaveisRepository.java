package com.arara.contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.arara.contabil.model.FuncaoResponsaveis;
import com.arara.contabil.model.RolResponsaveis;

public interface RolResponsaveisRepository extends Repository<RolResponsaveis, String> {

	RolResponsaveis save(RolResponsaveis rolResponsaveis);

	Optional<RolResponsaveis> findByCpf(String cpf);
	
	List<RolResponsaveis> findAllByFuncaoResponsaveis(FuncaoResponsaveis funcaoResponsaveis);
	
	@Query("select rr from RolResponsaveis rr inner join rr.funcaoResponsaveis fr where fr.organization.id = :id")
	List<RolResponsaveis> findAllByOrganizations(@Param("id") Long organizationId);
}