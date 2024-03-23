package com.arara.security.service;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.security.model.User;
import com.arara.security.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void updateLastLoginAtByEmail(String email) {
		int result = userRepository.setLastLoginAtByEmail(Instant.now(), email);
		logger.debug("updateLastLoginAtByEmail(" + email + ") -> " + result);
	}
	
	public List<User> listUsers() {
		return userRepository.findAll();
	}
}
