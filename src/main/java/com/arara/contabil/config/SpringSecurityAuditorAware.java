package com.arara.contabil.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

class SpringSecurityAuditorAware implements AuditorAware<Long> {
	
	Logger logger = LoggerFactory.getLogger(AuthenticationEvents.class);

	@Override
	public Optional<Long> getCurrentAuditor() {

		return Optional.ofNullable(SecurityContextHolder.getContext())
			.map(SecurityContext::getAuthentication)
			.filter(Authentication::isAuthenticated)
			.map(Authentication::getPrincipal)
			.map(UserDetails.class::cast)
			.map(UserDetails::getUsername)
			.map(username -> {
				try {
					return Long.parseLong(username);
				} catch (Exception e) {
					logger.error("Error parsing username {" + username + "} to Long, setting null for AuditorAware.getCurrentAuditor()", e);
					return null;
				}
			});
	}
}