package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.TitoloStudioDTO;
import com.entity.TitoloStudio;
import com.repository.TitoloStudioRepository;

@Service
public class TitoloStudioServiceImpl implements TitoloStudioService {

	@Autowired
	private TitoloStudioRepository tsr;

	@Override
	public List<TitoloStudio> getTitoli() {
		return tsr.findAll();
	}

	@Override
	public ResponseEntity<TitoloStudio> postTitolo(TitoloStudioDTO titoloDTO) {
		TitoloStudio t = toEntity(titoloDTO);
		t = tsr.findById(titoloDTO.getCandidato().getCandidatoId()).get();
		try {
			tsr.save(t);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<TitoloStudio> patchTitolo(Integer id) {
		try {
			Optional<TitoloStudio> t = tsr.findById(id);
			tsr.save(t.get());
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<TitoloStudio> deleteTitolo(Integer id) {
		try {
			tsr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private TitoloStudio toEntity(TitoloStudioDTO titoloDTO) {
		TitoloStudio t = new TitoloStudio();
		t.setDiploma(titoloDTO.getDiploma());
		t.setDataDiploma(titoloDTO.getDataDiploma());
		t.setLaurea(titoloDTO.getLaurea());
		t.setAnnoLaurea(titoloDTO.getAnnoLaurea());
		t.setLaureaInCorso(titoloDTO.getLaureaInCorso());
		t.setCertificazione(titoloDTO.getCertificazione());
		t.setDataScadenza(titoloDTO.getDataScadenza());
		t.setCandidato(titoloDTO.getCandidato());
		return t;
	}

}
