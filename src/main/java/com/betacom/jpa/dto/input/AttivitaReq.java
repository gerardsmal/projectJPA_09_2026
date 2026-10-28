package com.betacom.jpa.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AttivitaReq {
	private Integer id;
	private String descrizione;
	private Long prezzo;

}
