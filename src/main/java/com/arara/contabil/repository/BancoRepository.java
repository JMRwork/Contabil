package com.arara.contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.arara.contabil.model.Banco;

public interface BancoRepository extends Repository<Banco, String> {

	Banco save(Banco banco);

	Optional<Banco> findByCodigo(String codigo);

	List<Banco> findAll();
	
}