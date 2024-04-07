package com.arara.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arara.security.dto.UserDto;
import com.arara.security.model.User;
import com.arara.security.service.UserService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/users/register")
    public String registerPage(UserDto userDto) {
        return "register-user";
    }

    @PostMapping("/users/register")
    public String userRegister(@Validated UserDto userDto, BindingResult result){
    	if(result.hasErrors()){
            return "register-user";
        }
    	User user = new User();
    	user.setFullName(userDto.getFullName());
    	user.setEmail(userDto.getEmail());
    	user.setPassword(userDto.getPassword());
    	user.setRole(userDto.getRole());
    	if (userService.createUser(user)) {
    		return "redirect:/users";
    	}
    	ObjectError error = new ObjectError("globalError", "Este usuário já existe.");
    	result.addError(error);
    	return "register-user";
    }
}
