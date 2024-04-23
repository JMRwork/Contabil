package com.arara.security.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.arara.security.dto.ChangeUserPasswordDto;
import com.arara.security.dto.EditUserDto;
import com.arara.security.dto.NewUserDto;
import com.arara.security.dto.ViewUserDto;
import com.arara.security.model.User;
import com.arara.security.service.ConverterService;
import com.arara.security.service.OrganizationService;
import com.arara.security.service.UserService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {
	
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private ConverterService converterService;
	
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
    public String registerPage(NewUserDto newUserDto) {
        return "register-user";
    }

    @PostMapping("/users/register")
    public String userRegister(@Validated NewUserDto newUserDto, BindingResult result){
    	if(result.hasErrors()){
            return "register-user";
        }
    	User user = converterService.convertNewUserDtoToUserModel(newUserDto);
    	if (userService.createUser(user)) {
    		return "redirect:/users";
    	}
    	ObjectError error = new ObjectError("globalError", "Este e-mail já foi utilizado por outro usuário.");
    	result.addError(error);
    	return "register-user";
    }
    @GetMapping("/users/{id}/edit")
    public String editPage(@PathVariable("id") Long id, EditUserDto editUserDto, Model model, BindingResult result) {
    	Optional<User> user = userService.findUserById(id);
    	if(user.isEmpty()) {
    		ObjectError error = new ObjectError("globalError", "Usuário com id "+ id + " não existe.");
        	result.addError(error);
    		
    	} else {
    		model.addAttribute("user", converterService.convertUserModelToEditUserDto(user.get(), editUserDto));
    		model.addAttribute("organizations", organizationService.listOrganizations());
    	}
    	return "edit-user";
    }
    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") long id,@Validated EditUserDto editUserDto, BindingResult result, Model model) {
    	Optional<User> findUser = userService.findUserById(id);
    	model.addAttribute("user", findUser.get());
    	model.addAttribute("organizations", organizationService.listOrganizations());
    	if(id != editUserDto.getId()) {
    		ObjectError error = new ObjectError("globalError", "Falha de validação do Id do usuário. Tente novamente mais tarde. Caso ocorra novamente contate o administrador do sistema.");
        	result.addError(error);
    	}
    	if(findUser.isPresent()) {
    		User user = converterService.convertEditUserDtoToUserModel(editUserDto, findUser.get());
    		logger.info(user.toString());
    		logger.info(editUserDto.toString());
    		userService.updateUser(user);
    		return "redirect:/users/{id}/view";
    	} else { 
    		ObjectError error = new ObjectError("globalError", "Este usuário não existe.");
        	result.addError(error);
    	}
    	if(result.hasErrors()){
    		
          return "edit-user";
        }
    	return "edit-user";
    }
    
    @GetMapping("users/{id}/view")
    public String viewUser(@PathVariable("id") long id, Model model) {
    	Optional<User> user = userService.findUserById(id);
    	if (user.isEmpty()) {
    		model.addAttribute("user", null);
    	} else {
    		model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));	
    	}
    	return "view-user";
    }
    
    @GetMapping("users/{id}/delete")
    public String deleteUserPage(@PathVariable("id") long id, Model model) {
    	Optional<User> user = userService.findUserById(id);
    	if (user.isEmpty()) {
    		model.addAttribute("user", null);
    	} else {
    		model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));	
    	}
    	return "delete-user";
    }
    
    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id, ViewUserDto viewUserDto, BindingResult result) {
    	Optional<User> userToBeDeleted = userService.findUserById(id);
    	if (userToBeDeleted.isEmpty()) {
    		ObjectError error = new ObjectError("globalError", "Este usuário não foi encontrado.");
        	result.addError(error);
        	return "delete-user";
    	}
    	if(!userService.deleteUser(userToBeDeleted.get())) {
    		ObjectError error = new ObjectError("globalError", "Não foi possível deletar o usuário.");
        	result.addError(error);
    		return "delete-user";
    	}
    	return "redirect:/users";
    }
    
    @GetMapping("users/{id}/password")
    public String passwordUserPage(@PathVariable("id") long id, ChangeUserPasswordDto userNewPassword,Model model) {
    	Optional<User> user = userService.findUserById(id);
    	if (user.isEmpty()) {
    		model.addAttribute("user", null);
    	} else {
    		model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));	
    	}
    	return "password-user";
    }
    
    @PostMapping("users/{id}/password")
    public String changePasswordUser(@PathVariable("id") long id,@Validated ChangeUserPasswordDto userNewPasswordDto, BindingResult result, Model model) {
    	Optional<User> user = userService.findUserById(id);
    	model.addAttribute("user", user.get());
    	if (user.isEmpty()) {
    		ObjectError error = new ObjectError("globalError", "Este usuário não foi encontrado.");
        	result.addError(error);
    	}
    	if (!userNewPasswordDto.getPassword().equals(userNewPasswordDto.getRepeatPassword())){
    		ObjectError error = new ObjectError("globalError", "As senhas informadas não são iguais.");
        	result.addError(error);
    	}
    	if(result.hasErrors()){
    		return "password-user";
        }  	
    	User userNewPassword = user.get();
    	userNewPassword.setPassword(userNewPasswordDto.getPassword());
   		userService.changeUserPassword(userNewPassword);
   		return "redirect:/users/{id}/view";
    	
    }
    
}
