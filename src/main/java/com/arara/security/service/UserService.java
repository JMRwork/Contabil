package com.arara.security.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
	public void updateLastLoginAtByUsername(String username) {
		try {
			Long id = Long.parseLong(username);
			int result = userRepository.setLastLoginAtById(Instant.now(), id);
			logger.debug("updateLastLoginAtByUsername(" + username + ") -> " + result);
		} catch (Exception e) {
			logger.error("Error parsing username {" + username + "} to Long at UserService.updateLastLoginAtByUsername()", e);
		}
	}

	public List<User> listUsers() {
		return userRepository.findAll();
	}
	public void createUser(User user) {
		try {
			Optional<User> result = userRepository.findByEmail(user.getEmail());
			if (result == null) {
				userRepository.save(user);
				logger.debug("User " + user.getEmail() +" created");
			} else {
				logger.debug("this user already exists");
			}
		} catch (Exception e) {
			logger.error("Error:" + e);
		}
	}
}
