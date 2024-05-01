package com.arara.security.model;

import java.time.Instant;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class EscolaDadosCadastrais {

	@Id
	private Long organizationId;
	
	@Column(nullable = false)
	private String unidadeExecutora;
	
	@Column(nullable = false)
	private String nomeEscola;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false)
	private String siglaEscola;

	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String codigoInep;
	
	@CreatedBy
	private Long createdBy;
	
	@LastModifiedBy
	private Long lastModifiedBy;
	
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant lastModifiedAt;
    
    
    @OneToOne
    @JoinColumn(name="organization_id", nullable  = false)
    private Organization organization; 
    
    
}
