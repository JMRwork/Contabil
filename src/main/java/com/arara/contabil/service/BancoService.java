package com.arara.contabil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.Banco;
import com.arara.contabil.repository.BancoRepository;

@Service
public class BancoService {
	Logger logger = LoggerFactory.getLogger(BancoService.class);

	@Autowired
	private BancoRepository bancoRepository;

	public List<Banco> listBancos() {
		return bancoRepository.findAll();
	}

	public Optional<Banco> findById(String codigo) {
		return bancoRepository.findByCodigo(codigo);
	}

	public Banco saveBanco(Banco banco) {
		return bancoRepository.save(banco);
	}

}
