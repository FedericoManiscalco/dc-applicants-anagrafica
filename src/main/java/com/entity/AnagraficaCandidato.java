package com.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class AnagraficaCandidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidato_id")
	private Integer candidatoId;

	@Column(name = "codice_fiscale", nullable = false, unique = true)
	@NotBlank(message = "codice Fiscale non può essere vuoto")
	private String codiceFiscale;

	@Column(nullable = false)
	@NotBlank(message = "nome non può essere vuoto")
	private String nome;

	@Column(nullable = false)
	@NotBlank(message = "cognome non può essere vuoto")
	private String cognome;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "email non può essere vuota")
	private String email;

	@Column(name = "data_nascita", nullable = false)
	private Date dataNascita;

	@Column(name = "luogo_nascita", nullable = false)
	@NotBlank(message = "luogo di nascita non può essere vuota")
	private String luogoNascita;
	private Boolean cittadinanza;

	@Column(nullable = false)
	@NotBlank(message = "residenza non può essere vuota")
	private String residenza;

	@Column(name = "cap_residenza", nullable = false)
	@NotBlank(message = "cap residenza non può essere vuoto")
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

	@Column(name = "come_conosciuto_combo")
	private String comeConosciutoCombo;

}
