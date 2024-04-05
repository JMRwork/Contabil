package com.arara.security.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arara.security.model.Organization;
import com.arara.security.service.OrganizationService;

@RestController
@RequestMapping("api")
public class OrganizationsRestController {

	@Autowired
	private OrganizationService organizationService;
   
    @GetMapping("/organizations") 
    public List<Organization> listOrganizations() {
    	
        return organizationService.listOrganizations();
    }

}
