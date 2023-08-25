package com.entity;

import java.util.Date;

import com.enums.Contratto;
import com.enums.Qualifica;

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
public class PosizioneLavorativa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "posizione_lavorativa_id")
	private Integer posizioneLavorativaId;

	private String azienda;
	private Date dataInizio;

	@Enumerated(EnumType.STRING)
	private Qualifica qualifica;

	@Enumerated(EnumType.STRING)
	private Contratto contratto;

	@Column(name = "specifica_contratto")
	private String specificaContratto;
	private String livello;
	private Integer ral;

	@Column(name = "tariffa_giornaliera_netta")
	private Integer tariffaGiornalieraNetta;

	@Column(name = "nome_referente")
	private String nomeReferente;

	@Column(name = "normativa_privacy")
	private Boolean normativaPrivacy;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private AnagraficaCandidato candidato;

}
