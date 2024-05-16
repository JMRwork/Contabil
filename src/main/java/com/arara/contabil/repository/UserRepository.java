package com.arara.contabil.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.arara.contabil.model.User;

public interface UserRepository extends Repository<User, Long> {

	User save(User user);

	Optional<User> findById(Long id);

	Optional<User> findByEmail(String email);

	// Busca todos os usuarios
	List<User> findAll();
	
	// Busca todos os usuarios da organização, exceto deletados
	List<User> findAllByOrganizationsIn(List<Long> organizationIds);
	
	// Busca todos os usuarios, exceto deletados
	List<User> findAllByDeletedAtNull();

	// Busca todos usuarios deletados
	List<User> findAllByDeletedAtNotNull();
	
	@Query("select uo.id from User u inner join u.organizations uo where u.id = :id")
	List<Long> findAllOrganizationIdsByUserId(@Param("id") Long id);
	
	@Modifying
	@Query("update User u set u.lastLoginAt = :lastLoginAt where u.email = :email")
	int setLastLoginAtByEmail(@Param("lastLoginAt") Instant lastLoginAt, @Param("email") String email);
	
	@Modifying
	@Query("update User u set u.lastLoginAt = :lastLoginAt where u.id = :id")
	int setLastLoginAtById(@Param("lastLoginAt") Instant lastLoginAt, @Param("id") Long id);

}