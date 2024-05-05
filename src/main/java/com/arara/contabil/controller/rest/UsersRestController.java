package com.arara.contabil.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arara.contabil.model.User;
import com.arara.contabil.service.UserService;

@RestController
@RequestMapping("api")
public class UsersRestController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/users") 
    public List<User> listUsers() {
    	
        return userService.listUsers();
    }

}
