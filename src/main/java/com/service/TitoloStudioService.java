package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.TitoloStudioDTO;
import com.entity.TitoloStudio;

public interface TitoloStudioService {

	public List<TitoloStudio> getTitoli();

	public ResponseEntity<TitoloStudio> postTitolo(TitoloStudioDTO titoloDTO);

	public ResponseEntity<TitoloStudio> patchTitolo(Integer id);

	public ResponseEntity<TitoloStudio> deleteTitolo(Integer id);

}
