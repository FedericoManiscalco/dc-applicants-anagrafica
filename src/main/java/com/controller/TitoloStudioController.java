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

import com.dto.TitoloStudioDTO;
import com.entity.Titolo;
import com.service.TitoloStudioService;

@CrossOrigin
@RequestMapping("/titolo/v1")
@RestController
public class TitoloStudioController {

	@Autowired
	private TitoloStudioService tss;

	@GetMapping("/getTitolo")
	public List<Titolo> getTitoli() {
		return tss.getTitoli();
	}

	@PostMapping("/postTitoloStudio")
	public ResponseEntity<Titolo> postTitoloStudio(@RequestBody TitoloStudioDTO titoloStudioDTO) {
		return tss.postTitolo(titoloStudioDTO);
	}

	@PatchMapping("/patchTitoloStudio/{id}")
	public ResponseEntity<Titolo> patchTitoloStudio(@PathVariable Integer id) {
		return tss.patchTitolo(id);
	}

	@DeleteMapping("/deleteTitoloStudio/{id}")
	public ResponseEntity<Titolo> deleteTitolo(@PathVariable Integer id) {
		return tss.deleteTitolo(id);
	}

}
