package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EnumDTO;
import com.dto.EnumNameDTO;
import com.enums.Certificazione;
import com.enums.ComeConosciuto;
import com.enums.Contratto;
import com.enums.Diploma;
import com.enums.Laurea;
import com.enums.Livello;
import com.enums.Qualifica;

@CrossOrigin
@RequestMapping("/enums/v1")
@RestController
public class EnumController {

	@GetMapping("/getEnums")
	public EnumDTO getEnums() {
		EnumDTO enums = new EnumDTO();
		for (Certificazione b : Certificazione.values()) {
			enums.getCertificazione().add(new EnumNameDTO(b.getValue()));
		}
		for (Laurea b : Laurea.values()) {
			enums.getLaurea().add(new EnumNameDTO(b.getValue()));
		}
		for (Diploma b : Diploma.values()) {
			enums.getDiploma().add(new EnumNameDTO(b.getValue()));
		}
		for (Contratto b : Contratto.values()) {
			enums.getContratto().add(new EnumNameDTO(b.getValue()));
		}
		for (Livello b : Livello.values()) {
			enums.getLivello().add(new EnumNameDTO(b.getValue()));
		}
		for (Qualifica b : Qualifica.values()) {
			enums.getLivello().add(new EnumNameDTO(b.getValue()));
		}
		for (ComeConosciuto b : ComeConosciuto.values()) {
			enums.getLivello().add(new EnumNameDTO(b.getValue()));
		}

		return enums;
	}
}
