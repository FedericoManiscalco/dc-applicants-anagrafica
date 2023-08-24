package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.AnagraficaCandidatoDTO;
import com.entity.AnagraficaCandidato;

public interface AnagraficaCandidatoService {

	public List<AnagraficaCandidato> getAnagrafiche();

	public ResponseEntity<AnagraficaCandidato> postCandidato(AnagraficaCandidatoDTO candidatoDTO);

	public ResponseEntity<AnagraficaCandidato> patchCandidato(Integer id);

	public ResponseEntity<AnagraficaCandidato> deleteCandidato(Integer id);

}
