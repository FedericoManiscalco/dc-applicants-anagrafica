package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PosizioneLavorativaDTO;
import com.entity.PosizioneLavorativa;
import com.service.PosizioneLavorativaService;

@CrossOrigin
@RequestMapping("/posizione/v1")
@RestController
public class PosizioneLavorativaController {

	@Autowired
	private PosizioneLavorativaService pls;

	@GetMapping("/getPosizione")
	public List<PosizioneLavorativa> getPosizioni() {
		return pls.getPosizioni();
	}

	@PostMapping("/postPosizioneLavorativa")
	public ResponseEntity<PosizioneLavorativa> postPosizione(@RequestBody PosizioneLavorativaDTO posizioneDTO) {
		return pls.postPosizioneLavorativa(posizioneDTO);
	}

	@PatchMapping("/patchPosizioneLavorativa/{id}")
	public ResponseEntity<PosizioneLavorativa> patchPosizione(@PathVariable Integer id) {
		return pls.patchPosizioneLavorativa(id);
	}

	@DeleteMapping("/deletePosizioneLavorativa/{id}")
	public ResponseEntity<PosizioneLavorativa> deletePosizione(@PathVariable Integer id) {
		return pls.deletePosizioneLavorativa(id);
	}

}
