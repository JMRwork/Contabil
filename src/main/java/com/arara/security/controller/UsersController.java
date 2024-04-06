package com.arara.security.controller;

import com.arara.security.dto.UserDto;
import com.arara.security.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "registerUser";
    }

    @PostMapping("/users/register")
    public String userRegister(@ModelAttribute @Validated UserDto newUser, Errors errors, Model model){
        if(errors.hasErrors()){
            return "registerUser";
        }
        System.out.println(newUser);
        System.out.println(newUser.getPassword());
        return "redirect:/users";
    }
}
