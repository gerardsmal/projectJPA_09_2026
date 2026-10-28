package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.AttivitaDTO;
import com.betacom.jpa.models.Attivita;

public class AttivitaMap {

	public static List<AttivitaDTO> buildAttivitaDTOList(List<Attivita> lA){
		
		return lA.stream()
				.map(s -> buildAttivitaDTO(s)
						).toList();						
		
	}
	
	public static AttivitaDTO buildAttivitaDTO(Attivita a) {
		return AttivitaDTO.builder()
				.id(a.getId())
				.descrizione(a.getDescrizione())
				.prezzo(a.getPrezzo())
				.build();
	}
}
