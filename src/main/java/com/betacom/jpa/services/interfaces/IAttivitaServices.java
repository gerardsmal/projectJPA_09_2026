package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.dto.input.AttivitaReq;

public interface IAttivitaServices {

	void create(AttivitaReq req) throws Exception;
	void update(AttivitaReq req) throws Exception;
	void delete(Integer attivitaID) throws Exception;
}
