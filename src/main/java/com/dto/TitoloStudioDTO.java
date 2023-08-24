package com.dto;

import java.util.Date;

import com.entity.AnagraficaCandidato;
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
public class TitoloStudioDTO {

	private String laurea;
	private String annoLaurea;
	private String laureaInCorso;
	private String diploma;
	private String dataDiploma;
	private String certificazione;
	private Date dataScadenza;
	private AnagraficaCandidato candidato;

}
