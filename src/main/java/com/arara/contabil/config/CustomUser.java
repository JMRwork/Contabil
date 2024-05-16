package com.arara.contabil.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private List<Long> organizationIds;

	public CustomUser(Long id, List<Long> organizationIds, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.organizationIds = organizationIds;
	}

	public Long getId() {
		return id;
	}

	public List<Long> getOrganizationIds() {
		return organizationIds;
	}
	
}
