package com.arara.contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arara.contabil.config.CustomUser;
import com.arara.contabil.dto.CurrentOrganizationDto;
import com.arara.contabil.model.Organization;
import com.arara.contabil.service.ConverterService;
import com.arara.contabil.service.OrganizationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private ConverterService converterService;
	
	@GetMapping("/")
	public String showIndex(
			@RequestParam(name = "organizationId", required = false) Long organizationId,
			@AuthenticationPrincipal CustomUser userPrincipal,
			HttpSession session,
			Model model) {
		
		List<Organization> organizations = organizationService.listActiveOrganizations(userPrincipal);
		
		// se usuário tem apenas uma organização, escolha esta organização automaticamente
		if (session.getAttribute("currentOrganization") == null && organizationId == null && organizations.size() == 1) {
			CurrentOrganizationDto dto = converterService.convertOrganizationModelToCurrentOrganizationDto(organizations.getFirst());
			session.setAttribute("currentOrganization", dto);
		}
		
		// selecione organização escolhida pelo usuário
		if (organizationId != null) {
			for(Organization org: organizations) {
				if (org.getId() == organizationId) {
					CurrentOrganizationDto dto = converterService.convertOrganizationModelToCurrentOrganizationDto(org);
					session.setAttribute("currentOrganization", dto);
				}
			}
		}
		
		model.addAttribute("organizations", organizations); // TODO: use DTO
		
		return "home";
	}

}
