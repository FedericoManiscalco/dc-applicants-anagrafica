package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.PosizioneLavorativaDTO;
import com.entity.PosizioneLavorativa;

public interface PosizioneLavorativaService {

	public List<PosizioneLavorativa> getPosizioni();

	public ResponseEntity<PosizioneLavorativa> postPosizioneLavorativa(PosizioneLavorativaDTO posizioneDTO);

	public ResponseEntity<PosizioneLavorativa> patchPosizioneLavorativa(Integer id);

	public ResponseEntity<PosizioneLavorativa> deletePosizioneLavorativa(Integer id);

}
