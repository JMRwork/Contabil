package com.arara.security.controller;

import com.arara.security.dto.UserDto;
import com.arara.security.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import com.arara.security.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {
	
	@Autowired
	private UserService userService;
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/users/register")
    public String registerPage(Model model) {
    	model.addAttribute("userForm", new UserDto());
        return "registerUser";
    }

    @PostMapping("/users/register")
    public String userRegister(@Validated UserDto userForm, BindingResult result, Model model){
    	System.out.println(userForm);
    	if(result.hasErrors()){
    		//model.addAttribute("a", errors)
            return "registerUser";
        }
        System.out.println(userForm);
        System.out.println(userForm.getPassword());
        return "redirect:/users";
    }
}
