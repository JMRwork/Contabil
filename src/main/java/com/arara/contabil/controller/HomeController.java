package com.arara.contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showIndex(@RequestParam(name = "organizationId", required = false) Long organizationId, HttpSession session, Model model) {
		
		if(organizationId != null) {
			organizationService.findById(organizationId).ifPresent(org -> {
				CurrentOrganizationDto dto = converterService.convertOrganizationModelToCurrentOrganizationDto(org);
				session.setAttribute("currentOrganization", dto);
			});
		}
		
		List<Organization> organizations = organizationService.listOrganizations();
		model.addAttribute("organizations", organizations);
		
		return "index";
	}

}
