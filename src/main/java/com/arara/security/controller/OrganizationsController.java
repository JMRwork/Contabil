package com.arara.security.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arara.security.dto.ViewOrganizationDto;
import com.arara.security.model.Organization;
import com.arara.security.service.ConverterService;
import com.arara.security.service.OrganizationService;

@Controller
public class OrganizationsController {
	
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private OrganizationService organizationService;
	
    @GetMapping("/organizations")
    public String showUsers(Model model) {
        model.addAttribute("organizations", organizationService.listOrganizations());
        return "organizations";
    }
    
    @GetMapping("/organizations/{id}/view")
    public String viewUser(@PathVariable("id") long id, Model model) {
    	Optional<Organization> organization = organizationService.findById(id);
    	ViewOrganizationDto dto = converterService.convertOrganizationModelToViewOrganizationDto(organization.get());
    	model.addAttribute("organization", converterService.convertOrganizationModelToViewOrganizationDto(organization.get()));
    	logger.info(organization.get().toString());
    	logger.info(organization.get().getUsers().toString());
    	logger.info(dto.toString());
    	logger.info(dto.getUsers().toString());
    	return "view-organization";
    }
}
