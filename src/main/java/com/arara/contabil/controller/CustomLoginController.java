package com.arara.contabil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLoginController {

	@GetMapping("/customLogin")
	public String customLogin() {
		return "custom-login";
	}

}
