package com.arara.contabil.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arara.contabil.dto.EditEscolaDadosCadastraisDto;
import com.arara.contabil.dto.EditOrganizationDto;
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
		var cadastro = escolaDadosCadastraisService.findById(organizationId);
		if (cadastro.isPresent()) {
			model.addAttribute("cadastro", cadastro.get()); // TODO: use DTO
		}
		return "view-dados-cadastrais";
	}

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/dados-cadastrais/edit")
	public String editDadosCadastraisPage(@PathVariable("organizationId") Long organizationId,
			@RequestParam(value = "create", required = false, defaultValue = "false") boolean create,
			EditEscolaDadosCadastraisDto editEscolaDadosCadastraisDto, Model model, BindingResult result) {
		Optional<EscolaDadosCadastrais> escolaDadosCadastrais = escolaDadosCadastraisService.findById(organizationId);
		if (escolaDadosCadastrais.isEmpty()) {
			if (!create) {
				ObjectError error = new ObjectError("globalError",
						"Dados Cadastrais da organização de id " + organizationId + " não existe.");
				result.addError(error);
			}
		} else {
			model.addAttribute("EditEscolaDadosCadastraisDto",
					converterService.convertEscolaDadosCadastraisModelToEditEscolaDadosCadastraisDto(
							escolaDadosCadastrais.get(), editEscolaDadosCadastraisDto));
		}
		return "edit-dados-cadastrais";
	}

	@PreAuthorize("hasRole('ADMIN') || ( hasRole('ACCOUNTANT') && principal.organizationIds.contains(#organizationId) )")
	@PostMapping("/organizations/{organizationId}/dados-cadastrais/edit")
	public String editDadosCadastrais( //
			@PathVariable("organizationId") Long organizationId, //
			@Validated EditEscolaDadosCadastraisDto editEscolaDadosCadastraisDto, //
			BindingResult result, //
			Model model) {

		if (organizationId != editEscolaDadosCadastraisDto.getOrganizationId()) {
			ObjectError error = new ObjectError("globalError",
					"Falha de validação do Id da organização. Tente novamente mais tarde. Caso ocorra novamente contate o administrador do sistema.");
			result.addError(error);
		}

		if (result.hasErrors()) {
			return "edit-dados-cadastrais";
		}

		var escolaDadosCadastraisEditada = converterService
				.convertEditEscolaDadosCadastraisDtoToEscolaDadosCadastraisModel(editEscolaDadosCadastraisDto,
						new EscolaDadosCadastrais());
		escolaDadosCadastraisEditada.setOrganizationId(organizationId);
		if (escolaDadosCadastraisService.updateEscolaDadosCadastrais(escolaDadosCadastraisEditada)) {
			return "redirect:/organizations/{organizationId}/dados-cadastrais";
		}
		ObjectError error = new ObjectError("globalError", "Erro ao tentar Salvar os Dados Cadastrais.");
		result.addError(error);
		return "edit-dados-cadastrais";
	}
}
