package com.arara.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arara.security.service.UserService;

@Controller
public class UsersController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
	
    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
}
