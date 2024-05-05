package com.arara.contabil.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.arara.contabil.service.UserService;

@Component
public class AuthenticationEvents {

	Logger logger = LoggerFactory.getLogger(AuthenticationEvents.class);

	@Autowired
	private UserService userService;

	@EventListener
	public void onSuccess(AuthenticationSuccessEvent success) {
		logger.info("Login success event: " + success.toString());
		CustomUser user = (CustomUser)success.getAuthentication().getPrincipal();
		userService.updateLastLoginAtByUsername(user.getId());
	}

	@EventListener
	public void onFailure(AbstractAuthenticationFailureEvent failures) {
		logger.info("Login failure event: " + failures.toString());
	}

}