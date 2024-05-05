package com.arara.contabil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ContabilApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContabilApplication.class, args);
	}

}
