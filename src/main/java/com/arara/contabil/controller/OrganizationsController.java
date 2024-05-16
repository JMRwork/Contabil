package com.arara.contabil.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arara.contabil.config.CustomUser;
import com.arara.contabil.dto.EditOrganizationDto;
import com.arara.contabil.dto.NewOrganizationDto;
import com.arara.contabil.dto.ViewOrganizationDto;
import com.arara.contabil.model.Organization;
import com.arara.contabil.service.ConverterService;
import com.arara.contabil.service.OrganizationService;

@Controller
@RequestMapping("/organizations")
public class OrganizationsController {

	Logger logger = LoggerFactory.getLogger(OrganizationsController.class);

	@Autowired
	private ConverterService converterService;

	@Autowired
	private OrganizationService organizationService;

	@GetMapping
	public String showOrganizations(@AuthenticationPrincipal CustomUser userPrincipal, Model model) {
		model.addAttribute("organizations", organizationService.listOrganizations(userPrincipal));
		return "organizations";
	}

	@GetMapping("/{id}/view")
	public String viewOrganization(@PathVariable("id") Long id, Model model) {
		ViewOrganizationDto dto = organizationService.findById(id)
				.map(org -> converterService.convertOrganizationModelToViewOrganizationDto(org)) //
				.orElse(null);
		model.addAttribute("organization", dto);
		return "view-organization";
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'ACCOUNTANT')")
	@GetMapping("/{id}/edit")
	public String editOrganization(@PathVariable("id") Long id, EditOrganizationDto editOrganizationDto, Model model, BindingResult result) {
		Optional<Organization> organization = organizationService.findById(id);
		if (organization.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Organização com id " + id + " não existe.");
			result.addError(error);
		} else {
			model.addAttribute("editOrganizationDto", converterService.convertOrganizationModelToEditOrganizationDto(organization.get(), editOrganizationDto));
		}
		return "edit-organization";
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'ACCOUNTANT')")
	@PostMapping("/{id}/edit")
	public String editUser(@PathVariable("id") Long id, @Validated EditOrganizationDto editOrganizationDto, BindingResult result, Model model) {
		if (id != editOrganizationDto.getId()) {
			ObjectError error = new ObjectError("globalError",
				"Falha de validação do Id da organização. Tente novamente mais tarde. Caso ocorra novamente contate o administrador do sistema.");
			result.addError(error);
		}
		if(result.hasErrors()){
			return "edit-organization";
		}
		Optional<Organization> orgOpt = organizationService.findById(id);
		if (orgOpt.isPresent()) {
			Organization org = converterService.convertEditOrganizationDtoToOrganizationModel(editOrganizationDto, orgOpt.get());
			if(organizationService.updateOrganization(org)) {
				return "redirect:/organizations/{id}/view";
			}
			ObjectError error = new ObjectError("globalError", "Este Cnpj já está sendo usando por outra organização.");
			result.addError(error);
		} else {
			ObjectError error = new ObjectError("globalError", "Esta organização não existe.");
			result.addError(error);
		}
		return "edit-organization";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'ACCOUNTANT')")
	@GetMapping("/register")
	public String registerPage(NewOrganizationDto newOrganizationDto) {
		return "register-organization";
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'ACCOUNTANT')")
	@PostMapping("/register")
	public String organizationRegister(@Validated NewOrganizationDto newOrganizationDto, BindingResult result) {
		if (result.hasErrors()) {
			return "register-organization";
		}
		Organization org = converterService.convertNewOrganizationDtoToOrganizationModel(newOrganizationDto);
		if (organizationService.createOrganization(org)) {
			return "redirect:/organizations";
		}
		ObjectError error = new ObjectError("globalError", "Este cnpj já foi utilizado por outra escola.");
		result.addError(error);
		return "register-organization";
	}

}
