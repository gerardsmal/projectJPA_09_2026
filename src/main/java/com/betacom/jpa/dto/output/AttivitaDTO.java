package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AttivitaDTO {

	private Integer id;
	private String descrizione;
	private Long prezzo;
}
