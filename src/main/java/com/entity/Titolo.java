package com.entity;

import java.util.Date;

import com.enums.Certificazione;
import com.enums.Diploma;
import com.enums.Laurea;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Titolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer titoloId;

	@Enumerated(EnumType.STRING)
	private Laurea laurea;

	@Column(name = "anno_laurea")
	private String annoLaurea;

	@Enumerated(EnumType.STRING)
	@Column(name = "laurea_in_corso")
	private Laurea laureaInCorso;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Diploma diploma;

	@Column(name = "data_diploma", nullable = false)
	private String dataDiploma;

	@Enumerated(EnumType.STRING)
	private Certificazione certificazione;

	@Column(name = "data_scadenza")
	private Date dataScadenza;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private AnagraficaCandidato candidato;

}
