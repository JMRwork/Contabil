package com.arara.contabil.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arara.contabil.model.UserStatus;
import com.arara.contabil.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDetails userDetails = userRepository.findByEmail(email).map(u -> {
			
			String username = u.getId().toString();
			String password = u.getPassword();
			Boolean enabledUser = !u.getStatus().equals(UserStatus.DELETED);
			Boolean accountNonExpired = u.getStatus().equals(UserStatus.ACTIVE) || u.getStatus().equals(UserStatus.RESET_PASSWORD);
			Boolean credentialsNonExpired = !u.getStatus().equals(UserStatus.RESET_PASSWORD);
			Boolean accountNonLocked = !u.getStatus().equals(UserStatus.DISABLED);
			List<GrantedAuthority> listGrantAuthority = Arrays.asList(new SimpleGrantedAuthority(u.getRole()));
			return new User(username, password, enabledUser, accountNonExpired, credentialsNonExpired, accountNonLocked, listGrantAuthority);

		}).orElseThrow(() -> new UsernameNotFoundException("Bad credentials!"));
		
		return userDetails;
	}
	
}
