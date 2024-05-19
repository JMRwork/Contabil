package com.arara.contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.contabil.model.DomicilioBancario;
import com.arara.contabil.model.EscolaPrograma;
import com.arara.contabil.model.Organization;

public interface DomicilioBancarioRepository extends Repository<DomicilioBancario, Long> {

	DomicilioBancario save(DomicilioBancario db);

	Optional<DomicilioBancario> findById(Long codigo);

	List<DomicilioBancario> findAllByOrganization(Organization org);

	List<DomicilioBancario> findAllByEscolaPrograma(EscolaPrograma ep);

}