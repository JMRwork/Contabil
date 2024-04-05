package com.arara.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arara.security.service.OrganizationService;

@Controller
public class OrganizationsController {
	
	@Autowired
	private OrganizationService organizationService;
	
    @GetMapping("/organizations")
    public String showUsers(Model model) {
        model.addAttribute("organizations", organizationService.listOrganizations());
        return "organizations";
    }
}
