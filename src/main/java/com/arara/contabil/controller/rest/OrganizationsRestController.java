package com.arara.contabil.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arara.contabil.config.CustomUser;
import com.arara.contabil.model.Organization;
import com.arara.contabil.service.OrganizationService;

@RestController
@RequestMapping("api")
public class OrganizationsRestController {

	@Autowired
	private OrganizationService organizationService;
   
    @GetMapping("/organizations") 
    public List<Organization> listOrganizations(@AuthenticationPrincipal CustomUser userPrincipal) {
    	
        return organizationService.listOrganizations(userPrincipal);
    }

}
