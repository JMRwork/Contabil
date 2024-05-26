package com.arara.contabil.controller;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arara.contabil.config.CustomUser;
import com.arara.contabil.dto.EditOrganizationDto;
import com.arara.contabil.dto.NewOrganizationDto;
import com.arara.contabil.dto.ViewOrganizationDto;
import com.arara.contabil.dto.ViewUserDto;
import com.arara.contabil.model.Organization;
import com.arara.contabil.model.User;
import com.arara.contabil.model.UserRole;
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
		model.addAttribute("organizations", organizationService.listOrganizations(userPrincipal)); // TODO: use DTO
		return "organizations";
	}

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/{id}/view")
	public String viewOrganization(@PathVariable("id") Long id, Model model) {
		ViewOrganizationDto dto = organizationService.findById(id)
				.map(org -> converterService.convertOrganizationModelToViewOrganizationDto(org)) //
				.orElse(null);
		model.addAttribute("organization", dto);
		return "view-organization";
	}

	@PreAuthorize("hasRole('ADMIN') || ( hasRole('ACCOUNTANT') && principal.organizationIds.contains(#organizationId) )")
	@GetMapping("/{id}/edit")
	public String editOrganizationPage( //
			@PathVariable("id") Long id, //
			EditOrganizationDto editOrganizationDto, //
			Model model, //
			BindingResult result) {

		Optional<Organization> organization = organizationService.findById(id);
		if (organization.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Organização com id " + id + " não existe.");
			result.addError(error);
		} else {
			model.addAttribute("editOrganizationDto", converterService
					.convertOrganizationModelToEditOrganizationDto(organization.get(), editOrganizationDto));
		}
		return "edit-organization";
	}

	@PreAuthorize("hasRole('ADMIN') || ( hasRole('ACCOUNTANT') && principal.organizationIds.contains(#organizationId) )")
	@PostMapping("/{id}/edit")
	public String editOrganization( //
			@PathVariable("id") Long id, //
			@Validated EditOrganizationDto editOrganizationDto, //
			BindingResult result, //
			Model model) {

		if (id != editOrganizationDto.getId()) {
			ObjectError error = new ObjectError("globalError",
					"Falha de validação do Id da organização. Tente novamente mais tarde. Caso ocorra novamente contate o administrador do sistema.");
			result.addError(error);
		}
		if (result.hasErrors()) {
			return "edit-organization";
		}
		Optional<Organization> orgOpt = organizationService.findById(id);
		if (orgOpt.isPresent()) {
			Organization org = converterService.convertEditOrganizationDtoToOrganizationModel(editOrganizationDto,
					orgOpt.get());
			if (organizationService.updateOrganization(org)) {
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
	public String organizationRegister( //
			@Validated NewOrganizationDto newOrganizationDto, //
			@AuthenticationPrincipal CustomUser userPrincipal, //
			BindingResult result) {

		if (result.hasErrors()) {
			return "register-organization";
		}
		Organization org = converterService.convertNewOrganizationDtoToOrganizationModel(newOrganizationDto);
		if (userPrincipal.getAuthorities().contains(new SimpleGrantedAuthority(UserRole.ROLE_ACCOUNTANT.toString()))) {
			// Vincular usuário atual com role_accountant com a nova organização
			User currentUser = new User();
			currentUser.setId(userPrincipal.getId());
			Set<User> users = Set.of(currentUser);
			org.setUsers(users);
		}
		if (organizationService.createOrganization(org)) {
			return "redirect:/organizations";
		}
		ObjectError error = new ObjectError("globalError", "Este cnpj já foi utilizado por outra escola.");
		result.addError(error);
		return "register-organization";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}/delete")
	public String deleteOrganizationPage( //
			@PathVariable("id") long id, //
			@RequestParam(value="undo", required = false, defaultValue = "false") boolean undo, //
			Model model) {
		
		Optional<Organization> org = organizationService.findById(id);
		model.addAttribute("undo", undo);
		if (org.isEmpty()) {
			model.addAttribute("org", null);
		} else {
			var orgDto = new EditOrganizationDto();
			model.addAttribute("org", converterService.convertOrganizationModelToEditOrganizationDto(org.get(), orgDto));
		}
		return "delete-organization";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{id}/delete")
	public String deleteOrganization( //
			@PathVariable("id") long id, //
			@RequestParam(value="undo", required = false, defaultValue = "false") boolean undo, //
			ViewUserDto viewUserDto, //
			BindingResult result) {
		
		Optional<Organization> org = organizationService.findById(id);
		if (org.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Escola não foi encontrada.");
			result.addError(error);
			return "delete-organization";
		}
		if (undo) {
			if (!organizationService.undoDeleteOrganization(org.get())) {
				ObjectError error = new ObjectError("globalError", "Não foi possível restaurar a escola.");
				result.addError(error);
				return "delete-organization";
			}
		} else {
			if (!organizationService.deleteOrganization(org.get())) {
				ObjectError error = new ObjectError("globalError", "Não foi possível remover a escola.");
				result.addError(error);
				return "delete-organization";
			}
		}
		return "redirect:/organizations";
	}

}
