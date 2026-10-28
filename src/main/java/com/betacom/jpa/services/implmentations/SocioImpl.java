package com.betacom.jpa.services.implmentations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.SocioDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mapper.SocioMap;
import com.betacom.jpa.models.Socio;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SocioImpl implements ISocioServices{

	private final ISocioRepository socioR;

	@Transactional
	@Override
	public void create(SocioReq req) throws Exception {
		log.debug("create ()", req);
		if (socioR.existsByCodiceFiscale(req.getCodiceFiscale()))
			throw new AcademyException("codice fiscale presente in DB");
		
		Socio soc = new Socio();
		soc.setCodiceFiscale(req.getCodiceFiscale());
		soc.setCognome(req.getCognome());
		soc.setEmail(req.getEmail());
		soc.setNome(req.getNome());
		socioR.save(soc);
	}

	@Transactional
	@Override
	public void update(SocioReq req) throws Exception {
		log.debug("update {}", req);
		Socio soc = socioR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("Socio non trovato"));
			
		if (req.getCodiceFiscale() != null && !req.getCodiceFiscale().equalsIgnoreCase(soc.getCodiceFiscale())) {
			if (socioR.existsByCodiceFiscale(req.getCodiceFiscale()))
				throw new AcademyException("codice fiscale presente in DB");
			soc.setCodiceFiscale(req.getCodiceFiscale());
		}
		
		if (req.getCognome() != null) soc.setCognome(req.getCognome());
		if (req.getNome() != null) soc.setNome(req.getNome());		
		if (req.getEmail() != null) soc.setEmail(req.getEmail());
		socioR.save(soc);
		
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Socio soc = socioR.findById(id)
				.orElseThrow(() -> new AcademyException("Socio non trovato"));
		
		socioR.delete(soc);
	}

	@Override
	public List<SocioDTO> list() throws Exception {
		List<Socio> lS = socioR.findAll();
		return SocioMap.buildSocioDTO(lS);
	}

	@Override
	public List<SocioDTO> listByCognome(String cognome) throws Exception {
		log.debug("listByCognome {}", cognome);
		List<Socio> lS = socioR.searchByCognome(cognome);
		
		return SocioMap.buildSocioDTO(lS);
	}

	@Override
	public List<SocioDTO> listByAttivita(Integer attivitaID) throws Exception {
		log.debug("listByAttivita {}", attivitaID);
		List<Socio> lS = socioR.selectByAttivita(attivitaID);
		
		return SocioMap.buildSocioDTO(lS);
	}
	

}
