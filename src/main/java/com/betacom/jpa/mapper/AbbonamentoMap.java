package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.AbbonamentoDTO;
import com.betacom.jpa.models.Abbonamento;

public class AbbonamentoMap {
	
	public static List<AbbonamentoDTO>  buildAbbonamentoDTO(List<Abbonamento> lA) {
		return lA.stream()
				.map(a -> buildAbbonamentoDTO(a))
				.toList();		
	}
	
	public static AbbonamentoDTO buildAbbonamentoDTO(Abbonamento a) {
		return AbbonamentoDTO.builder()
				.id(a.getId())
				.dataAbbonamento(a.getDataAbbonamento())
				.durataAbbonamento(a.getDurataAbbonamento())
				.build();
	}
}
