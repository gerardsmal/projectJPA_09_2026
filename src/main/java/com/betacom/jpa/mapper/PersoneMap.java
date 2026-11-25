package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.PersoneDTO;
import com.betacom.jpa.models.Personne;

public class PersoneMap {

	public static List<PersoneDTO>  buildPersoneDTO(List<Personne> lP) {
		return lP.stream()
				.map(a -> buildPersoneDTO(a))
				.toList();		
	}
	
	public static PersoneDTO buildPersoneDTO(Personne a) {
		return PersoneDTO.builder()
				.id(a.getId())
				.nome(a.getNome())
				.cognome(a.getCognome())
				.email(a.getEmail())
				.colore(a.getColore())
				.build();
	}
}
