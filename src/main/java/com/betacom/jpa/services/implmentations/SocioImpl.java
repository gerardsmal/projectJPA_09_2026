package com.betacom.jpa.services.implmentations;

import java.util.List;

import org.springframework.stereotype.Service;

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

	@Override
	public void create(SocioReq req) throws Exception {
		log.debug("create ()", req);
		if (socioR.existsByCodiceFiscale(req.getCodiceFiascale()))
			throw new AcademyException("codice fiscale presente in DB");
		
		Socio soc = new Socio();
		soc.setCodiceFiscale(req.getCodiceFiascale());
		soc.setCognome(req.getCognome());
		soc.setEmail(req.getEmail());
		soc.setNome(req.getNome());
		socioR.save(soc);
	}

	@Override
	public void update(SocioReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SocioDTO> list() throws Exception {
		List<Socio> lS = socioR.findAll();
		return SocioMap.buildSocioDTO(lS);
	}
	

}
