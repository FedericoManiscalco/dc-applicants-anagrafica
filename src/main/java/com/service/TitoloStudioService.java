package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.TitoloStudioDTO;
import com.entity.Titolo;

public interface TitoloStudioService {

	public List<Titolo> getTitoli();

	public ResponseEntity<Titolo> postTitolo(TitoloStudioDTO titoloDTO);

	public ResponseEntity<Titolo> patchTitolo(Integer id);

	public ResponseEntity<Titolo> deleteTitolo(Integer id);

}
