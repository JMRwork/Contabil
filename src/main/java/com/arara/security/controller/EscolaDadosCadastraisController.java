package com.arara.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.security.model.Organization;
import com.arara.security.service.EscolaDadosCadastraisService;
import com.arara.security.service.MovimentoService;

@Controller
public class EscolaDadosCadastraisController {

	@Autowired
	private EscolaDadosCadastraisService escolaDadosCadastraisService;

	@GetMapping("/organizations/{organization_id}/dados-cadastrais")
	public String showDadosCadastrais(@PathVariable("organization_id") Long organizationId, Model model) {
		model.addAttribute("cadastro", escolaDadosCadastraisService.findById(organizationId));
		return "view-dados-cadastrais";
	}
}
