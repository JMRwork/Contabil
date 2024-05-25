package com.arara.contabil.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.contabil.dto.EditEscolaDadosCadastraisDto;
import com.arara.contabil.model.EscolaDadosCadastrais;
import com.arara.contabil.model.Organization;
import com.arara.contabil.service.ConverterService;
import com.arara.contabil.service.EscolaDadosCadastraisService;

@Controller
public class EscolaDadosCadastraisController {

	@Autowired
	private EscolaDadosCadastraisService escolaDadosCadastraisService;
	
	@Autowired
	private ConverterService converterService;

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/dados-cadastrais")
	public String showDadosCadastrais(@PathVariable("organizationId") Long organizationId, Model model) {
		model.addAttribute("cadastro", escolaDadosCadastraisService.findById(organizationId).get());
		return "view-dados-cadastrais";
	}
	
	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/dados-cadastrais/edit")
	public String editDadosCadastrais(@PathVariable("organizationId") Long organizationId, 
			EditEscolaDadosCadastraisDto editEscolaDadosCadastraisDto, 
			Model model, 
			BindingResult result) {
		Optional<EscolaDadosCadastrais> escolaDadosCadastrais = escolaDadosCadastraisService.findById(organizationId);
		if (escolaDadosCadastrais.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Dados Cadastrais da organização de id " + organizationId + " não existe.");
			result.addError(error);
		} else {
			model.addAttribute("EditEscolaDadosCadastraisDto", converterService
					.convertEscolaDadosCadastraisModelToEditEscolaDadosCadastraisDto(escolaDadosCadastrais.get(), editEscolaDadosCadastraisDto));
		}
		return "edit-dados-cadastrais";
	}
}
