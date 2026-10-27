package com.betacom.jpa.services.implmentations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.AbbonamentoReq;
import com.betacom.jpa.dto.output.AbbonamentoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Socio;
import com.betacom.jpa.repositories.IAbbonamentoRepository;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AbbonamentoImpl implements IAbbonamentoServices{
	
	private final IAbbonamentoRepository abbR;
	private final ISocioRepository       socR;
	
	@Transactional
	@Override
	public void create(AbbonamentoReq req) throws Exception {
		log.debug("create {}", req);
		Socio soc = socR.findById(req.getSocioID())
				.orElseThrow(() -> new AcademyException("Socio non trovato"));
		Abbonamento abb = new Abbonamento();
		abb.setDataAbbonamento(req.getDataAbbonamento());
		abb.setDurataAbbonamento(req.getDurataAbbonamento() == null ? 6 : req.getDurataAbbonamento());
		
		abb.setSocio(soc);
		abbR.save(abb);
	}
	
	@Transactional
	@Override
	public void update(AbbonamentoReq req) throws Exception {
		log.debug("update {}", req);
		Socio soc = socR.findById(req.getSocioID())
				.orElseThrow(() -> new AcademyException("Socio non trovato"));
		
		Abbonamento abb = soc.getAbbonamento().stream()
				.filter(a -> a.getId().equals(req.getId()))
				.findFirst()
				.orElseThrow(() -> new AcademyException("Abbonamento non trovato per il socio "));
		
		if (req.getDataAbbonamento() != null) abb.setDataAbbonamento(req.getDataAbbonamento());
		if (req.getDurataAbbonamento() != null) abb.setDurataAbbonamento(req.getDurataAbbonamento());
		
		abbR.save(abb);
		
	}

	@Override
	public void delete(Integer abbonamentoID, Integer socioID) throws Exception {
		log.debug("delete {} / {}", abbonamentoID, socioID);
		Socio soc = socR.findById(socioID)
				.orElseThrow(() -> new AcademyException("Socio non trovato"));
		
		Abbonamento abb = soc.getAbbonamento().stream()
				.filter(a -> a.getId().equals(abbonamentoID))
				.findFirst()
				.orElseThrow(() -> new AcademyException("Abbonamento non trovato per il socio "));
		abbR.delete(abb);
		
	}

	@Override
	public List<AbbonamentoDTO> listBySocio(Integer socioId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
