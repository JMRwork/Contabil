package com.arara.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arara.security.dto.UserDto;
import com.arara.security.model.User;
import com.arara.security.service.OrganizationService;
import com.arara.security.service.UserService;

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
    @GetMapping("/users/{id}/edit")
    public String editPage(@PathVariable("id") Long id, Model model) {
    	Optional<User> user = userService.findUserById(id);
    	if(user.isEmpty()) {
    		model.addAttribute("user", null);
    	} else {
    		model.addAttribute("user", user.get());
    		model.addAttribute("organizations", organizationService.listOrganizations());
    	}
    	return "edit-user";
    }
}
