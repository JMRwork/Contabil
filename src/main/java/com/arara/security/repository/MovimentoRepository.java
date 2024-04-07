package com.arara.security.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.arara.security.model.Movimento;
import com.arara.security.model.Organization;

public interface MovimentoRepository extends Repository<Movimento, Long> {

	Movimento save(Movimento movimento);

	// Busca movimento filtrando por organizacao (evita acesso a dados que o usuario nao tem acesso)
	Optional<Movimento> findByOrganizationAndId(Organization organization, Long id);

	// Busca todos os movimentos, com paginacao, filtrando por organizacao
	Page<Movimento> findAllByOrganization(Organization organization, Pageable pageable);
	
	// Busca todos os movimentos, com paginacao, filtrando por organizacao e excluindo registros marcados como deletados
	Page<Movimento> findAllByOrganizationAndDeletedAtNull(Organization organization, Pageable pageable);
	
	// Busca todos os movimentos, com paginacao, filtrando por organizacao e incluindo apenas registros marcados como deletados
	Page<Movimento> findAllByOrganizationAndDeletedAtNotNull(Organization organization, Pageable pageable);

}