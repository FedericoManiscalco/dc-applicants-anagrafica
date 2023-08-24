package com.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

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

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AnagraficaCandidatoDTO {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String email;
	private Date dataNascita;
	private String luogoNascita;
	private Boolean cittadinanza;
	private String residenza;
	private String capResidenza;
	private String domicilio;
	private String capDomicilio;
	private String recapitoMobile;
	private Boolean categoriaProtetta;
	private Boolean condanneCivili;
	private String comeConosciutoCombo;

}
