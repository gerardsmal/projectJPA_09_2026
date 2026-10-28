package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.output.AttivitaDTO;

public interface IAttivitaServices {

	void create(AttivitaReq req) throws Exception;
	void update(AttivitaReq req) throws Exception;
	void delete(Integer attivitaID) throws Exception;
	
	List<AttivitaDTO> list() throws Exception;
}
