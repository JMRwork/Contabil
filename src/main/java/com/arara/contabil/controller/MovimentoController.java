package com.arara.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

	@GetMapping("/movimento/{organization_id}")
	public String showUsers(@PathVariable("organization_id") Long organizationId, Model model) {
		Organization org = new Organization();
		org.setId(organizationId);
		Pageable pageable = Pageable.unpaged();
		model.addAttribute("movimento", movimentoService.listMovimentoPage(org, pageable));
		return "movimento";
	}
}
