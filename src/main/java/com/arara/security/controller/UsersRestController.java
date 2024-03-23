package com.arara.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arara.security.model.User;
import com.arara.security.service.UserService;

@RestController
public class UsersRestController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/users") 
    public List<User> listUsers() {
    	
        return userService.listUsers();
    } 

}
