package com.entity;

import java.util.Date;

import com.enums.ComeConosciuto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class AnagraficaCandidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidato_id")
	private Integer candidatoId;

	@Column(name = "codice_fiscale", nullable = false, unique = true)
	private String codiceFiscale;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "data_nascita", nullable = false)
	private Date dataNascita;

	@Column(name = "luogo_nascita", nullable = false)
	private String luogoNascita;
	private Boolean cittadinanza;

	@Column(nullable = false)
	private String residenza;

	@Column(name = "cap_residenza", nullable = false)
	private String capResidenza;

	private String domicilio;

	@Column(name = "cap_domicilio")
	private String capDomicilio;

	@Column(name = "recapito_mobile", nullable = false, unique = true)
	private String recapitoMobile;

	@Column(name = "categoria_protetta")
	private Boolean categoriaProtetta;

	@Column(name = "condanne_civili")
	private Boolean condanneCivili;

	@Column(name = "come_conosciuto")
	@Enumerated(EnumType.STRING)
	private ComeConosciuto comeConosciuto;

}
