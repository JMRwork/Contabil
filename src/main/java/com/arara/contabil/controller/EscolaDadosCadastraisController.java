package com.arara.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.contabil.service.EscolaDadosCadastraisService;

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
