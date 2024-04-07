package com.arara.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.arara.security.model.Movimento;
import com.arara.security.model.Organization;
import com.arara.security.repository.MovimentoRepository;

@Service
public class MovimentoService {

	Logger logger = LoggerFactory.getLogger(MovimentoService.class);

	@Autowired
	private MovimentoRepository movimentoRepository;

	public Page<Movimento> listMovimentoPage(Organization org, Pageable pageable) {
		return movimentoRepository.findAllByOrganizationAndDeletedAtNull(org, pageable);
	}
}
