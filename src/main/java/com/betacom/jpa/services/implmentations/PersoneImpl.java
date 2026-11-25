package com.betacom.jpa.services.implmentations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.PersoneReq;
import com.betacom.jpa.dto.output.PersoneDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mapper.PersoneMap;
import com.betacom.jpa.models.Personne;
import com.betacom.jpa.repositories.IPersoneRepository;
import com.betacom.jpa.services.interfaces.IPersoneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersoneImpl implements IPersoneServices{

	private final IPersoneRepository repP;
	
	@Transactional
	@Override
	public void create(PersoneReq req) throws Exception {
		log.debug("create {}", req);
		Personne p = new Personne();
		p.setCognome(req.getCognome());
		p.setColore(req.getColore());
		p.setEmail(req.getEmail());
		p.setNome(req.getNome());
		
		repP.save(p);
		
	}

	@Transactional
	@Override
	public void update(PersoneReq req) throws Exception {
		log.debug("update {}", req);
		Personne p = repP.findById(req.getId())
				.orElseThrow(() -> new AcademyException("persone non trovate"));
		
		if (req.getCognome() != null) p.setCognome(req.getCognome());
		if (req.getColore() != null) p.setColore(req.getColore());
		if (req.getEmail() != null) p.setEmail(req.getEmail());
		if (req.getNome() != null) p.setNome(req.getNome());
		
		repP.save(p);
		
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Personne p = repP.findById(id)
				.orElseThrow(() -> new AcademyException("persone non trovate"));
		repP.delete(p);
	}

	@Override
	public List<PersoneDTO> list() throws Exception {
		log.debug("list ");
		List<Personne> lP = repP.findAll();
		
		return PersoneMap.buildPersoneDTO(lP);
	}

	@Override
	public PersoneDTO getById(Integer id) throws Exception {
		log.debug("getById {}", id);
		
		Personne p = repP.findById(id)
				.orElseThrow(() -> new AcademyException("persone non trovate"));
		return PersoneMap.buildPersoneDTO(p);
	}

}
