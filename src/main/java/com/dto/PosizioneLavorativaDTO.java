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
public class PosizioneLavorativaDTO {

	private String azienda;
	private Date dataInizio;
	private String contratto;
	private String specificaContratto;
	private String qualifica;
	private String livello;
	private Integer ral;
	private Integer tariffaGiornalieraNetta;
	private String nomeReferente;
	private Boolean normativaPrivacy;
	private Integer candidatoId;

}
