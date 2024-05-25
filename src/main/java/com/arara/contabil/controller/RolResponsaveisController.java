package com.arara.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.contabil.service.RolResponsaveisService;

@Controller
public class RolResponsaveisController {

	@Autowired
	private RolResponsaveisService rolResponsaveisService;

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/responsaveis")
	public String showRolResponsaveis(@PathVariable("organizationId") Long organizationId, Model model) {
		model.addAttribute("rolResponsaveis", rolResponsaveisService.findAllByOrganization(organizationId)); // TODO: use DTO
		return "view-rol-responsaveis";
	}
}
