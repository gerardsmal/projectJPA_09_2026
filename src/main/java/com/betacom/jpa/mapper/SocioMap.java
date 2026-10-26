package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.CertificatoDTO;
import com.betacom.jpa.dto.output.SocioDTO;
import com.betacom.jpa.models.Socio;

public class SocioMap {
	
	public static SocioDTO buildSocioDTO(Socio s) {
		return SocioDTO.builder()
				.id(s.getId())
				.cognome(s.getCognome())
				.nome(s.getNome())
				.codiceFiascale(s.getCodiceFiscale())
				.email(s.getEmail())
				.certificato(s.getCertificato() == null ? null : CertificatoDTO.builder()
						.id(s.getCertificato().getId())
						.dataCerticifato(s.getCertificato().getDataCerticifato())
						.tipo(s.getCertificato().getTipo() ? "agonistico" : "normale")
						.build())
				.build();
	}
	
	public static List<SocioDTO> buildSocioDTO(List<Socio> lS){
		return lS.stream()
				.map(s -> buildSocioDTO(s))
				.toList();
	}
}
