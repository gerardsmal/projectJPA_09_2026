package com.betacom.jpa.services.implmentations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.CertificatoReq;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Certificato;
import com.betacom.jpa.models.Socio;
import com.betacom.jpa.repositories.ICertificatoRepository;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.services.interfaces.ICertificatoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CertificatoImpl implements ICertificatoServices{
	private final ICertificatoRepository cerR;
	private final ISocioRepository socioR;
	
	@Transactional
	@Override
	public void updateCertificato(CertificatoReq req) throws Exception {
		log.debug("Begin updateCertificato {}",req);
		
		Socio soc = socioR.findById(req.getSocioID())
				.orElseThrow(() -> new AcademyException("Socio non travato in DB"));
		
		Certificato cer = null;
		if (soc.getCertificato() == null) {
			log.debug("new certificato per {}", soc.getId());
			cer = new Certificato();
		} else 
			cer = soc.getCertificato();
		
		cer.setDataCerticifato(req.getDataCerticifato());
		cer.setTipo(req.getTipo() == null ? false : req.getTipo());
		
		soc.setCertificato(cerR.save(cer));
		socioR.save(soc);
		
	}

}
