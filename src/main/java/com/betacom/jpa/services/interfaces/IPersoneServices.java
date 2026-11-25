package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.PersoneReq;
import com.betacom.jpa.dto.output.PersoneDTO;

public interface IPersoneServices {
	void create(PersoneReq req) throws Exception;
	void update(PersoneReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
	List<PersoneDTO> list() throws Exception;
	PersoneDTO getById(Integer id) throws Exception;
}
