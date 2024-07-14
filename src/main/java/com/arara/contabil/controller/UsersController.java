package com.arara.contabil.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arara.contabil.config.CustomUser;
import com.arara.contabil.dto.ChangeUserPasswordDto;
import com.arara.contabil.dto.EditUserDto;
import com.arara.contabil.dto.NewUserDto;
import com.arara.contabil.dto.ViewUserDto;
import com.arara.contabil.model.User;
import com.arara.contabil.service.ConverterService;
import com.arara.contabil.service.OrganizationService;
import com.arara.contabil.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;

	@GetMapping
	public String showUsers(@AuthenticationPrincipal CustomUser userPrincipal, Model model) {
		model.addAttribute("users", userService.listUsers(userPrincipal)); // TODO: use DTO
		return "list-users";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/register")
	public String registerPage(NewUserDto newUserDto) {
		return "register-user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/register")
	public String userRegister(@Validated NewUserDto newUserDto, BindingResult result) {
		if (result.hasErrors()) {
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

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}/edit")
	public String editPage(
			@PathVariable("id") Long id,
			@AuthenticationPrincipal CustomUser userPrincipal,
			EditUserDto editUserDto,
			Model model,
			BindingResult result) {
		
		Optional<User> user = userService.findUserById(id);
		if (user.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Usuário com id " + id + " não existe.");
			result.addError(error);

		} else {
			model.addAttribute("editUserDto", converterService.convertUserModelToEditUserDto(user.get(), editUserDto));
			model.addAttribute("organizations", organizationService.listOrganizations(userPrincipal)); // TODO: use DTO
		}
		return "edit-user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{id}/edit")
	public String editUser(
			@PathVariable("id") long id,
			@AuthenticationPrincipal CustomUser userPrincipal,
			@Validated EditUserDto editUserDto,
			BindingResult result,
			Model model) {
		
		if (id != editUserDto.getId()) {
			ObjectError error = new ObjectError("globalError",
					"Falha de validação do Id do usuário. Tente novamente mais tarde. Caso ocorra novamente contate o administrador do sistema.");
			logger.info("id != editUserDto");
			result.addError(error);
		}
		if (result.hasErrors()) {
			logger.info("hasErrors");
			model.addAttribute("organizations", organizationService.listOrganizations(userPrincipal)); // TODO: use DTO
			return "edit-user";
		}
		Optional<User> findUser = userService.findUserById(id);
		if (findUser.isPresent()) {
			User user = converterService.convertEditUserDtoToUserModel(editUserDto, findUser.get());
			if (userService.updateUser(user)) {
				return "redirect:/users/{id}/view";
			}
			ObjectError error = new ObjectError("globalError", "Este email já está sendo usado por outro usuário.");
			result.addError(error);
		} else {
			ObjectError error = new ObjectError("globalError", "Este usuário não existe.");
			result.addError(error);
		}

		model.addAttribute("organizations", organizationService.listOrganizations(userPrincipal)); // TODO: use DTO
		return "edit-user";
	}

	@PreAuthorize("hasRole('ADMIN') || #id == principal.id ")
	@GetMapping("/{id}/view")
	public String viewUser(@PathVariable("id") long id, Model model) {
		Optional<User> user = userService.findUserById(id);
		if (user.isEmpty()) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));
		}
		return "view-user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}/delete")
	public String deleteUserPage(@PathVariable("id") long id, Model model) {
		Optional<User> user = userService.findUserById(id);
		if (user.isEmpty()) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));
		}
		return "delete-user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") long id, ViewUserDto viewUserDto, BindingResult result) { // TODO: delete viewUserDto and test
		Optional<User> userToBeDeleted = userService.findUserById(id);
		if (userToBeDeleted.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Este usuário não foi encontrado.");
			result.addError(error);
			return "delete-user";
		}
		if (!userService.deleteUser(userToBeDeleted.get())) {
			ObjectError error = new ObjectError("globalError", "Não foi possível deletar o usuário.");
			result.addError(error);
			return "delete-user";
		}
		return "redirect:/users";
	}

	@PreAuthorize("hasRole('ADMIN') || #id == principal.id ")
	@GetMapping("/{id}/password")
	public String changePasswordUserPage(@PathVariable("id") long id, ChangeUserPasswordDto userNewPassword, Model model) {
		Optional<User> user = userService.findUserById(id);
		if (user.isEmpty()) {
			model.addAttribute("user", null);
		} else {
			model.addAttribute("user", converterService.convertUserModelToViewUserDto(user.get()));
		}
		return "register-password-user";
	}

	@PreAuthorize("hasRole('ADMIN') || #id == principal.id ")
	@PostMapping("/{id}/password")
	public String changePasswordUser(@PathVariable("id") long id, @Validated ChangeUserPasswordDto userNewPasswordDto,
			BindingResult result, Model model) {
		Optional<User> user = userService.findUserById(id);
		if (user.isEmpty()) {
			ObjectError error = new ObjectError("globalError", "Este usuário não foi encontrado.");
			result.addError(error);
		} else {
			model.addAttribute("user", user.get()); // TODO: use DTO
		}
		if (!userNewPasswordDto.getPassword().equals(userNewPasswordDto.getRepeatPassword())) {
			ObjectError error = new ObjectError("globalError", "As senhas informadas não são iguais.");
			result.addError(error);
		}
		if (result.hasErrors()) {
			return "password-user";
		}
		User userNewPassword = user.get();
		userNewPassword.setPassword(userNewPasswordDto.getPassword());
		userService.changeUserPassword(userNewPassword);
		return "redirect:/users/{id}/view";

	}

}
