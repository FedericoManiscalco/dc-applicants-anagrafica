package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.PosizioneLavorativaDTO;
import com.entity.PosizioneLavorativa;
import com.enums.Contratto;
import com.enums.Qualifica;
import com.repository.AnagraficaCandidatoRepository;
import com.repository.PosizioneLavorativaRepository;

@Service
public class PosizioneLavorativaServiceImpl implements PosizioneLavorativaService {

	@Autowired
	private PosizioneLavorativaRepository plr;

	@Autowired
	private AnagraficaCandidatoRepository ac;

	@Override
	public List<PosizioneLavorativa> getPosizioni() {
		return plr.findAll();
	}

	@Override
	public ResponseEntity<PosizioneLavorativa> postPosizioneLavorativa(PosizioneLavorativaDTO posizioneDTO) {
		PosizioneLavorativa p = toEntity(posizioneDTO);
		try {
			p.setCandidato(ac.findById(posizioneDTO.getCandidatoId()).get());
			plr.save(p);
			return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<PosizioneLavorativa> patchPosizioneLavorativa(Integer id) {
		try {
			Optional<PosizioneLavorativa> p = plr.findById(id);
			plr.save(p.get());
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<PosizioneLavorativa> deletePosizioneLavorativa(Integer id) {
		try {
			plr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private PosizioneLavorativa toEntity(PosizioneLavorativaDTO posizioneDTO) {
		PosizioneLavorativa t = new PosizioneLavorativa();
//		Livello livelloEnum = null;
		Contratto contrattoEnum = null;
		Qualifica qualificaEnum = null;

//		if (posizioneDTO.getLivello() != null) {
//			livelloEnum = Livello.fromString(posizioneDTO.getLivello());
//		}
		if (posizioneDTO.getContratto() != null) {
			contrattoEnum = Contratto.fromString(posizioneDTO.getContratto());
		}
		if (posizioneDTO.getQualifica() != null) {
			qualificaEnum = Qualifica.fromString(posizioneDTO.getQualifica());
		}
		t.setAzienda(posizioneDTO.getAzienda());
		t.setDataInizio(posizioneDTO.getDataInizio());
		t.setContratto(contrattoEnum);
		t.setSpecificaContratto(posizioneDTO.getSpecificaContratto());
		t.setQualifica(qualificaEnum);
		t.setLivello(posizioneDTO.getLivello());
		t.setRal(posizioneDTO.getRal());
		t.setTariffaGiornalieraNetta(posizioneDTO.getTariffaGiornalieraNetta());
		t.setNomeReferente(posizioneDTO.getNomeReferente());
		t.setNormativaPrivacy(posizioneDTO.getNormativaPrivacy());
		return t;
	}

}
