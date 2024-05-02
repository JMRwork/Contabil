package com.arara.security.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.arara.security.dto.EditOrganizationDto;
import com.arara.security.dto.EditUserDto;
import com.arara.security.dto.NewOrganizationDto;
import com.arara.security.dto.NewUserDto;
import com.arara.security.dto.ViewOrganizationDto;
import com.arara.security.dto.ViewUserDto;
import com.arara.security.model.Organization;
import com.arara.security.model.User;

@Service
public class ConverterService {
	
	Logger logger = LoggerFactory.getLogger(ConverterService.class);

	public User convertNewUserDtoToUserModel(NewUserDto newUserDto) {
		User user = new User();
		user.setFullName(newUserDto.getFullName());
		user.setEmail(newUserDto.getEmail());
		user.setPassword(newUserDto.getPassword());
		user.setRole(newUserDto.getRole());
		return user;
	}

	public User convertEditUserDtoToUserModel(EditUserDto editUserDto, User user) {

		if (editUserDto.getFullName() != "" || editUserDto.getFullName() != null) {
			user.setFullName(editUserDto.getFullName());
		}
		if (editUserDto.getEmail() != "" || editUserDto.getEmail() != null) {
			user.setEmail(editUserDto.getEmail());
		}
		user.setRole(editUserDto.getRole());
		user.setStatus(editUserDto.getStatus());
		user.setOrganizations(editUserDto.getOrganizations());
		return user;
	}

	public EditUserDto convertUserModelToEditUserDto(User user, EditUserDto editUserDto) {
		editUserDto.setFullName(user.getFullName());
		editUserDto.setEmail(user.getEmail());
		editUserDto.setRole(user.getRole());
		editUserDto.setStatus(user.getStatus());
		editUserDto.setOrganizations(user.getOrganizations());
		return editUserDto;
	}

	public ViewUserDto convertUserModelToViewUserDto(User user) {
		ViewUserDto viewUserDto = new ViewUserDto();
		viewUserDto.setId(user.getId());
		viewUserDto.setFullName(user.getFullName());
		viewUserDto.setEmail(user.getEmail());
		viewUserDto.setRole(user.getRole());
		viewUserDto.setStatus(user.getStatus());
		viewUserDto.setCreatedBy(user.getCreatedBy());
		viewUserDto.setLastModifiedBy(user.getLastModifiedBy());
		viewUserDto.setCreatedAt(user.getLastModifiedAt());
		viewUserDto.setLastModifiedAt(user.getLastModifiedAt());
		viewUserDto.setLastLoginAt(user.getLastLoginAt());

		List<ViewOrganizationDto> viewOrganizationDtos = new ArrayList<>();
		for (Organization org : user.getOrganizations()) {
			// basic org info only
			ViewOrganizationDto viewOrganizationDto = new ViewOrganizationDto();
			viewOrganizationDto.setId(org.getId());
			viewOrganizationDto.setCnpj(org.getCnpj());
			viewOrganizationDto.setName(org.getName());
			viewOrganizationDto.setLegalName(org.getLegalName());
			viewOrganizationDto.setIsActive(org.getIsActive());

			viewOrganizationDtos.add(viewOrganizationDto);
		}
		viewUserDto.setOrganizations(viewOrganizationDtos);

		return viewUserDto;
	}

	public ViewOrganizationDto convertOrganizationModelToViewOrganizationDto(Organization org) {
		ViewOrganizationDto viewOrganizationDto = new ViewOrganizationDto();
		viewOrganizationDto.setId(org.getId());
		viewOrganizationDto.setCnpj(org.getCnpj());
		viewOrganizationDto.setName(org.getName());
		viewOrganizationDto.setLegalName(org.getLegalName());
		viewOrganizationDto.setIsActive(org.getIsActive());
		viewOrganizationDto.setCreatedAt(org.getCreatedAt());
		viewOrganizationDto.setCreatedBy(org.getCreatedBy());
		viewOrganizationDto.setLastModifiedAt(org.getLastModifiedAt());
		viewOrganizationDto.setLastModifiedBy(org.getLastModifiedBy());
		viewOrganizationDto.setDeletedAt(org.getDeletedAt());

		List<ViewUserDto> viewUserDtos = new ArrayList<>();
		for (User user : org.getUsers()) {
			// basic user info only
			ViewUserDto viewUserDto = new ViewUserDto();
			viewUserDto.setId(user.getId());
			viewUserDto.setEmail(user.getEmail());
			viewUserDto.setFullName(user.getFullName());
			viewUserDto.setRole(user.getRole());
			viewUserDto.setStatus(user.getStatus());

			viewUserDtos.add(viewUserDto);
		}
		viewOrganizationDto.setUsers(viewUserDtos);

		return viewOrganizationDto;
	}

	public EditOrganizationDto convertOrganizationModelToEditOrganizationDto(Organization org, EditOrganizationDto dto) {
		dto.setId(org.getId());
		dto.setCnpj(org.getCnpj());
		dto.setName(org.getName());
		dto.setLegalName(org.getLegalName());
		dto.setIsActive(org.getIsActive());
		return dto;
	}

	public Organization convertEditOrganizationDtoToOrganizationModel(EditOrganizationDto dto, Organization org) {

		if (dto.getCnpj() != "" || dto.getCnpj() != null) {
			org.setCnpj(dto.getCnpj());
		}

		if (dto.getName() != "" || dto.getName() != null) {
			org.setName(dto.getName());
		}

		if (dto.getLegalName() != "" || dto.getLegalName() != null) {
			org.setLegalName(dto.getLegalName());
		}

		if (dto.getIsActive() != null) {
			org.setIsActive(dto.getIsActive());
		}

		return org;
	}
	
	public Organization convertNewOrganizationDtoToOrganizationModel(NewOrganizationDto newOrganizationDto) {
		Organization org = new Organization();
		org.setCnpj(newOrganizationDto.getCnpj());
		org.setName(newOrganizationDto.getName());
		org.setLegalName(newOrganizationDto.getLegalName());
		org.setIsActive(newOrganizationDto.getIsActive());
		return org;
	}
}
