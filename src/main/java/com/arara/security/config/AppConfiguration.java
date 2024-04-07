package com.arara.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
@EnableJpaAuditing
public class AppConfiguration {

	@Bean
	SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}

	@Bean
	AuditorAware<Long> auditorProvider() {
		return new SpringSecurityAuditorAware();
	}

}
