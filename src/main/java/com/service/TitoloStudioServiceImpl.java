package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.TitoloStudioDTO;
import com.entity.Titolo;
import com.enums.Certificazione;
import com.enums.Diploma;
import com.enums.Laurea;
import com.repository.AnagraficaCandidatoRepository;
import com.repository.TitoloStudioRepository;

@Service
public class TitoloStudioServiceImpl implements TitoloStudioService {

	@Autowired
	private TitoloStudioRepository tsr;

	@Autowired
	private AnagraficaCandidatoRepository ac;

	@Override
	public List<Titolo> getTitoli() {
		return tsr.findAll();
	}

	@Override
	public ResponseEntity<Titolo> postTitolo(TitoloStudioDTO titoloDTO) {
		Titolo t = toEntity(titoloDTO);
		try {
			t.setCandidato(ac.findById(titoloDTO.getCandidatoId()).get());
			tsr.save(t);
			return new ResponseEntity<>(t, HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<Titolo> patchTitolo(Integer id) {
		try {
			Optional<Titolo> t = tsr.findById(id);
			tsr.save(t.get());
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Titolo> deleteTitolo(Integer id) {
		try {
			tsr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private Titolo toEntity(TitoloStudioDTO titoloDTO) {
		Titolo t = new Titolo();
		Laurea laureaEnum = null;
		Diploma diplomaEnum = null;
		Certificazione certificazioneEnum = null;

		if (titoloDTO.getLaurea() != null)
			laureaEnum = Laurea.fromString(titoloDTO.getLaurea());
		if (titoloDTO.getDiploma() != null)
			diplomaEnum = Diploma.fromString(titoloDTO.getDiploma());
		if (titoloDTO.getCertificazione() != null)
			certificazioneEnum = Certificazione.fromString(titoloDTO.getCertificazione());
		t.setDiploma(diplomaEnum);
		t.setDataDiploma(titoloDTO.getDataDiploma());
		t.setLaurea(laureaEnum);
		t.setAnnoLaurea(titoloDTO.getAnnoLaurea());
		t.setLaureaInCorso(laureaEnum);
		t.setCertificazione(certificazioneEnum);
		t.setDataScadenza(titoloDTO.getDataScadenza());
		return t;
	}

}
