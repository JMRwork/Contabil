package com.arara.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.contabil.model.Organization;
import com.arara.contabil.service.MovimentoService;

@Controller
public class MovimentoController {

	@Autowired
	private MovimentoService movimentoService;

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/movimento")
	public String showUsers(@PathVariable("organizationId") Long organizationId, Model model) {
		Organization org = new Organization();
		org.setId(organizationId);
		Pageable pageable = Pageable.unpaged();
		model.addAttribute("movimento", movimentoService.listMovimentoPage(org, pageable)); // TODO: use DTO
		model.addAttribute("currentOrganization", org); // TODO: use DTO
		return "list-movimento";
	}
}
