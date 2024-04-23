package com.arara.security.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arara.security.model.User;
import com.arara.security.model.UserStatus;
import com.arara.security.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}

	public List<User> listUsers() {
		return userRepository.findAll();
	}
	public Boolean createUser(User user) {
		Optional<User> result = userRepository.findByEmail(user.getEmail());
		if (result.isEmpty()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setStatus(UserStatus.ACTIVE);
			userRepository.save(user);
			logger.debug("User " + user.getEmail() +" created");
			return true;
		} else {
			logger.debug("this user "+ user.getEmail() +" already exists");
			return false;
			
		}	
	} 
	public Boolean updateUser(User user){
		userRepository.save(user);
		return true;
		// Revisar
	}
	public Boolean deleteUser(User user) {
		user.setStatus(UserStatus.DELETED);
		userRepository.save(user);
		return true;
		// Criar função no Repositorio
	} 
	public Boolean changeUserPassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return true;
	}
}
