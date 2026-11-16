package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.AbbonamentoDTO;
import com.betacom.jpa.dto.output.UtenteDTO;
import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Utente;

public class UtenteMap {
	
	public static List<UtenteDTO>  buildUtenteDTO(List<Utente> lU) {
		return lU.stream()
				.map(a -> buildUtenteDTO(a))
				.toList();		
	}
	
	public static UtenteDTO buildUtenteDTO(Utente a) {
		return UtenteDTO.builder()
				.userName(a.getUserName())
				.pwd(a.getPwd())
				.email(a.getEmail())
				.role(a.getRole().toString())
				.build();
	}
}
