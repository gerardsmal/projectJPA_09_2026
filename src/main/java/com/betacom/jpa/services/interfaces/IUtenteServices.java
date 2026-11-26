package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.LoginReq;
import com.betacom.jpa.dto.input.UtenteReq;
import com.betacom.jpa.dto.output.LoginDTO;
import com.betacom.jpa.dto.output.UtenteDTO;

public interface IUtenteServices {
	void create(UtenteReq req) throws Exception;
	void update(UtenteReq req) throws Exception;
	void delete(String userName) throws Exception;
	
	List<UtenteDTO> list();
	UtenteDTO getByUserName(String userName) throws Exception;
	
	LoginDTO login(LoginReq req) throws Exception;
}
