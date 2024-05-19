package com.arara.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.contabil.model.Organization;
import com.arara.contabil.service.DomicilioBancarioService;

@Controller
public class DomicilioBancarioController {

	@Autowired
	private DomicilioBancarioService domicilioBancarioService;

	@PreAuthorize("hasRole('ADMIN') || principal.organizationIds.contains(#organizationId)")
	@GetMapping("/organizations/{organizationId}/domicilio-bancarios")
	public String showDomicilioBancarios(@PathVariable("organizationId") Long organizationId, Model model) {
		Organization org = new Organization();
		org.setId(organizationId);
		model.addAttribute("domicilio-bancarios", domicilioBancarioService.listDomiciliosBancariosByOrganization(org));
		model.addAttribute("currentOrganization", org);
		return "domicilio-bancarios";
	}
}
