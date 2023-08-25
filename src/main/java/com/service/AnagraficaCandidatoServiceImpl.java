package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.AnagraficaCandidatoDTO;
import com.entity.AnagraficaCandidato;
import com.enums.ComeConosciuto;
import com.repository.AnagraficaCandidatoRepository;

@Service
public class AnagraficaCandidatoServiceImpl implements AnagraficaCandidatoService {

	@Autowired
	private AnagraficaCandidatoRepository ac;

	@Override
	public List<AnagraficaCandidato> getAnagrafiche() {
		return ac.findAll();
	}

	@Override
	public ResponseEntity<AnagraficaCandidato> postCandidato(AnagraficaCandidatoDTO candidatoDTO) {
		try {
			AnagraficaCandidato c = toEntity(candidatoDTO);
			ac.save(c);
			return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<AnagraficaCandidato> patchCandidato(Integer id) {
		try {
			Optional<AnagraficaCandidato> c = ac.findById(id);
			ac.save(c.get());
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<AnagraficaCandidato> deleteCandidato(Integer id) {
		try {
			ac.deleteById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private AnagraficaCandidato toEntity(AnagraficaCandidatoDTO candidatoDTO) {
		AnagraficaCandidato c = new AnagraficaCandidato();
		ComeConosciuto comeConosciutoEnum = null;

		c.setNome(candidatoDTO.getNome());
		c.setCognome(candidatoDTO.getCognome());
		c.setCodiceFiscale(candidatoDTO.getCodiceFiscale());
		c.setEmail(candidatoDTO.getEmail());
		c.setDataNascita(candidatoDTO.getDataNascita());
		c.setLuogoNascita(candidatoDTO.getLuogoNascita());
		c.setCittadinanza(candidatoDTO.getCittadinanza());
		c.setResidenza(candidatoDTO.getResidenza());
		c.setCapResidenza(candidatoDTO.getCapResidenza());
		c.setCapDomicilio(candidatoDTO.getCapDomicilio());
		c.setCategoriaProtetta(candidatoDTO.getCategoriaProtetta());
		c.setCondanneCivili(candidatoDTO.getCondanneCivili());
		c.setRecapitoMobile(candidatoDTO.getRecapitoMobile());
		if (candidatoDTO.getComeConosciuto() != null) {
			comeConosciutoEnum = ComeConosciuto.fromString(candidatoDTO.getComeConosciuto());
		}
		c.setComeConosciuto(comeConosciutoEnum);
		return c;

	}

}
