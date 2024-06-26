package com.arara.contabil.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.arara.contabil.dto.CurrentOrganizationDto;
import com.arara.contabil.dto.EditEscolaDadosCadastraisDto;
import com.arara.contabil.dto.EditOrganizationDto;
import com.arara.contabil.dto.EditUserDto;
import com.arara.contabil.dto.NewOrganizationDto;
import com.arara.contabil.dto.NewUserDto;
import com.arara.contabil.dto.ViewOrganizationDto;
import com.arara.contabil.dto.ViewUserDto;
import com.arara.contabil.model.EscolaDadosCadastrais;
import com.arara.contabil.model.Organization;
import com.arara.contabil.model.User;
import com.arara.contabil.model.UserRole;

@Service
public class ConverterService {

	Logger logger = LoggerFactory.getLogger(ConverterService.class);

	public User convertNewUserDtoToUserModel(NewUserDto newUserDto) {
		User user = new User();
		user.setFullName(newUserDto.getFullName());
		user.setEmail(newUserDto.getEmail());
		user.setPassword(newUserDto.getPassword());
		user.setRole(UserRole.valueOf(newUserDto.getRole()));
		return user;
	}

	public User convertEditUserDtoToUserModel(EditUserDto editUserDto, User user) {

		if (editUserDto.getFullName() != "" || editUserDto.getFullName() != null) {
			user.setFullName(editUserDto.getFullName());
		}
		if (editUserDto.getEmail() != "" || editUserDto.getEmail() != null) {
			user.setEmail(editUserDto.getEmail());
		}
		user.setRole(UserRole.valueOf(editUserDto.getRole()));
		user.setStatus(editUserDto.getStatus());
		user.setOrganizations(editUserDto.getOrganizations());
		return user;
	}

	public EditUserDto convertUserModelToEditUserDto(User user, EditUserDto editUserDto) {
		editUserDto.setFullName(user.getFullName());
		editUserDto.setEmail(user.getEmail());
		editUserDto.setRole(String.valueOf(user.getRole()));
		editUserDto.setStatus(user.getStatus());
		editUserDto.setOrganizations(user.getOrganizations());
		return editUserDto;
	}

	public ViewUserDto convertUserModelToViewUserDto(User user) {
		ViewUserDto viewUserDto = new ViewUserDto();
		viewUserDto.setId(user.getId());
		viewUserDto.setFullName(user.getFullName());
		viewUserDto.setEmail(user.getEmail());
		viewUserDto.setRole(String.valueOf(user.getRole()));
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
			viewUserDto.setRole(String.valueOf(user.getRole()));
			viewUserDto.setStatus(user.getStatus());

			viewUserDtos.add(viewUserDto);
		}
		viewOrganizationDto.setUsers(viewUserDtos);

		return viewOrganizationDto;
	}

	public EditOrganizationDto convertOrganizationModelToEditOrganizationDto(Organization org,
			EditOrganizationDto dto) {
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

	public CurrentOrganizationDto convertOrganizationModelToCurrentOrganizationDto(Organization org) {
		CurrentOrganizationDto dto = new CurrentOrganizationDto();
		dto.setId(org.getId());
		dto.setName(org.getName());
		dto.setCnpj(org.getCnpj());

		return dto;
	}

	public EditEscolaDadosCadastraisDto convertEscolaDadosCadastraisModelToEditEscolaDadosCadastraisDto(
			EscolaDadosCadastrais escolaDadosCadastrais, EditEscolaDadosCadastraisDto editEscolaDadosCadastraisDto) {
		editEscolaDadosCadastraisDto.setOrganizationId(escolaDadosCadastrais.getOrganizationId());
		editEscolaDadosCadastraisDto.setExercicio(escolaDadosCadastrais.getExercicio());
		editEscolaDadosCadastraisDto.setUnidadeExecutora(escolaDadosCadastrais.getUnidadeExecutora());
		editEscolaDadosCadastraisDto.setNomeEscola(escolaDadosCadastrais.getNomeEscola());
		editEscolaDadosCadastraisDto.setCnpj(escolaDadosCadastrais.getCnpj());
		editEscolaDadosCadastraisDto.setSiglaEscola(escolaDadosCadastrais.getSiglaEscola());
		editEscolaDadosCadastraisDto.setEndereco(escolaDadosCadastrais.getEndereco());
		editEscolaDadosCadastraisDto.setCidade(escolaDadosCadastrais.getCidade());
		editEscolaDadosCadastraisDto.setUf(escolaDadosCadastrais.getUf());
		editEscolaDadosCadastraisDto.setCep(escolaDadosCadastrais.getCep());
		editEscolaDadosCadastraisDto.setTelefone(escolaDadosCadastrais.getTelefone());
		editEscolaDadosCadastraisDto.setEmail(escolaDadosCadastrais.getEmail());
		editEscolaDadosCadastraisDto.setCodigoInep(escolaDadosCadastrais.getCodigoInep());
		return editEscolaDadosCadastraisDto;
	}

	public EscolaDadosCadastrais convertEditEscolaDadosCadastraisDtoToEscolaDadosCadastraisModel(
			EditEscolaDadosCadastraisDto editEscolaDadosCadastraisDto, EscolaDadosCadastrais escolaDadosCadastrais) {
		if (editEscolaDadosCadastraisDto.getOrganizationId() != null) {
			escolaDadosCadastrais.setOrganizationId(editEscolaDadosCadastraisDto.getOrganizationId());
		}
		if (editEscolaDadosCadastraisDto.getExercicio() != "" || editEscolaDadosCadastraisDto.getExercicio() != null) {
			escolaDadosCadastrais.setExercicio(editEscolaDadosCadastraisDto.getExercicio());
		}
		if (editEscolaDadosCadastraisDto.getUnidadeExecutora() != ""
				|| editEscolaDadosCadastraisDto.getUnidadeExecutora() != null) {
			escolaDadosCadastrais.setUnidadeExecutora(editEscolaDadosCadastraisDto.getUnidadeExecutora());
		}
		if (editEscolaDadosCadastraisDto.getNomeEscola() != ""
				|| editEscolaDadosCadastraisDto.getNomeEscola() != null) {
			escolaDadosCadastrais.setNomeEscola(editEscolaDadosCadastraisDto.getNomeEscola());
		}
		if (editEscolaDadosCadastraisDto.getCnpj() != "" || editEscolaDadosCadastraisDto.getCnpj() != null) {
			escolaDadosCadastrais.setCnpj(editEscolaDadosCadastraisDto.getCnpj());
		}
		if (editEscolaDadosCadastraisDto.getSiglaEscola() != ""
				|| editEscolaDadosCadastraisDto.getSiglaEscola() != null) {
			escolaDadosCadastrais.setSiglaEscola(editEscolaDadosCadastraisDto.getSiglaEscola());
		}
		if (editEscolaDadosCadastraisDto.getEndereco() != "" || editEscolaDadosCadastraisDto.getEndereco() != null) {
			escolaDadosCadastrais.setEndereco(editEscolaDadosCadastraisDto.getEndereco());
		}
		if (editEscolaDadosCadastraisDto.getCidade() != "" || editEscolaDadosCadastraisDto.getCidade() != null) {
			escolaDadosCadastrais.setCidade(editEscolaDadosCadastraisDto.getCidade());
		}
		if (editEscolaDadosCadastraisDto.getUf() != null) {
			escolaDadosCadastrais.setUf(editEscolaDadosCadastraisDto.getUf());
		}
		if (editEscolaDadosCadastraisDto.getCep() != "" || editEscolaDadosCadastraisDto.getCep() != null) {
			escolaDadosCadastrais.setCep(editEscolaDadosCadastraisDto.getCep());
		}
		if (editEscolaDadosCadastraisDto.getTelefone() != "" || editEscolaDadosCadastraisDto.getTelefone() != null) {
			escolaDadosCadastrais.setTelefone(editEscolaDadosCadastraisDto.getTelefone());
		}
		if (editEscolaDadosCadastraisDto.getEmail() != "" || editEscolaDadosCadastraisDto.getEmail() != null) {
			escolaDadosCadastrais.setEmail(editEscolaDadosCadastraisDto.getEmail());
		}
		if (editEscolaDadosCadastraisDto.getCodigoInep() != ""
				|| editEscolaDadosCadastraisDto.getCodigoInep() != null) {
			escolaDadosCadastrais.setCodigoInep(editEscolaDadosCadastraisDto.getCodigoInep());
		}
		return escolaDadosCadastrais;
	}
}
