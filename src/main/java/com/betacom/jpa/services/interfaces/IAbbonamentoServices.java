package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.AbbonamentoReq;
import com.betacom.jpa.dto.output.AbbonamentoDTO;

public interface IAbbonamentoServices {

	void create(AbbonamentoReq req) throws Exception;
	void update(AbbonamentoReq req) throws Exception;
	void delete(Integer abbonamentoID, Integer socioID) throws Exception;
	
	List<AbbonamentoDTO> listBySocio(Integer socioId)  throws Exception;
}
