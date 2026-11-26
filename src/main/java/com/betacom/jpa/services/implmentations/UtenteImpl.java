
package com.betacom.jpa.services.implmentations;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.LoginReq;
import com.betacom.jpa.dto.input.UtenteReq;
import com.betacom.jpa.dto.output.LoginDTO;
import com.betacom.jpa.dto.output.UtenteDTO;
import com.betacom.jpa.enums.Roles;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mapper.UtenteMap;
import com.betacom.jpa.models.Utente;
import com.betacom.jpa.repositories.IUtenteRepository;
import com.betacom.jpa.services.interfaces.IUtenteServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UtenteImpl implements IUtenteServices{
	
	private final IUtenteRepository utR;
	private final PasswordEncoder   passwordEncoder;
	
	@Transactional
	@Override
	public void create(UtenteReq req) throws Exception {
		log.debug("create {}", req);
		if (utR.existsById(req.getUserName()))
			throw new AcademyException("User esiste in db");
		Utente ut = new Utente();
		ut.setUserName(req.getUserName());
		ut.setPwd(passwordEncoder.encode(req.getPwd()));
		ut.setEmail(req.getEmail());
		ut.setRole(Roles.valueOf(req.getRole()));
		utR.save(ut);
	}

	@Override
	public void update(UtenteReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userName) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UtenteDTO> list() {
		log.debug("list");
		List<Utente> lU = utR.findAll();
		return UtenteMap.buildUtenteDTO(lU);
	}

	@Override
	public UtenteDTO getByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDTO login(LoginReq req) throws Exception {
		log.debug("login {}", req);
		Utente ut = utR.findById(req.getUserName())
				.orElseThrow(() -> new AcademyException("UserName/Password invalido"));
		if (!passwordEncoder.matches(req.getPassword(), ut.getPwd()))
			throw new AcademyException("UserName/Password invalido");
		
		
		return LoginDTO.builder()
				.role(ut.getRole().toString())
				.build();
	}

}
