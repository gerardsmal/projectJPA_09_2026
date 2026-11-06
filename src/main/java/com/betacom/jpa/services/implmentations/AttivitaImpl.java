package com.betacom.jpa.services.implmentations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.output.AttivitaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mapper.AttivitaMap;
import com.betacom.jpa.models.Attivita;
import com.betacom.jpa.repositories.IAttivitaRepository;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service
public class AttivitaImpl implements IAttivitaServices{
	
	private final IAttivitaRepository attivR;
	
	@Override
	public void create(AttivitaReq req) throws Exception {
		if (attivR.existsByDescrizione(req.getDescrizione().trim().toUpperCase()))
			throw new AcademyException("attiv-exist");
		Attivita at = new Attivita();

		at.setDescrizione(req.getDescrizione().trim().toUpperCase());
		at.setPrezzo(req.getPrezzo());
	
		attivR.save(at);
		
	}

	@Override
	public void update(AttivitaReq req) throws Exception {
		log.debug("update {}", req);
		Attivita at = attivR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("attiv-ntfnd"));
		
		Optional.ofNullable(req.getDescrizione())
	    	.map(d -> d.trim().toUpperCase())
	    	.filter(d -> !d.equals(at.getDescrizione()))
	    	.ifPresent(d -> {
	    		if (attivR.existsByDescrizione(d)) {
	    			throw new AcademyException("attiv-exis");
	    		}
	    		at.setDescrizione(d);
	    });
		
		Optional.ofNullable(req.getPrezzo()).ifPresent(at::setPrezzo);
		
		attivR.save(at);
		
	}

	@Override
	public void delete(Integer attivitaID) throws Exception {
		log.debug("delete {}", attivitaID);
		Attivita at = attivR.findById(attivitaID)
				.orElseThrow(() -> new AcademyException("attiv-ntfnd"));
		if (!at.getAbbonamento().isEmpty())
			throw new AcademyException("attiv-abbo-fnd"); 
		attivR.delete(at);


		 log.debug("Attivita cancellata");
		
	}

	@Override
	public List<AttivitaDTO> list() throws Exception {
		List<Attivita> lA = attivR.findAll(Sort.by("descrizione"));
		
		return AttivitaMap.buildAttivitaDTOList(lA);
	}

}
