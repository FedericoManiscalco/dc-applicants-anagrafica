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

import com.dto.AnagraficaCandidatoDTO;
import com.entity.AnagraficaCandidato;
import com.service.AnagraficaCandidatoService;

@CrossOrigin
@RequestMapping("/anagrafica/v1")
@RestController
public class AnagraficaCandidatoController {

	@Autowired
	private AnagraficaCandidatoService acs;

	@GetMapping("/getAnagrafica")
	public List<AnagraficaCandidato> getAnagrafica() {
		return acs.getAnagrafiche();
	}

	@PostMapping("/postAnagraficaCandidato")
	public ResponseEntity<AnagraficaCandidato> postAnagrafica(@RequestBody AnagraficaCandidatoDTO candidatoDTO) {
		return acs.postCandidato(candidatoDTO);
	}

	@PatchMapping("/patchAnagraficaCandidato/{id}")
	public ResponseEntity<AnagraficaCandidato> patchAnagrafica(@PathVariable Integer id) {
		return acs.patchCandidato(id);
	}

	@DeleteMapping("/deleteAnagraficaCandidato/{id}")
	public ResponseEntity<AnagraficaCandidato> deleteAnagrafica(@PathVariable Integer id) {
		return acs.deleteCandidato(id);
	}

}
