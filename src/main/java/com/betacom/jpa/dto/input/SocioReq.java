package com.betacom.jpa.dto.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class SocioReq {
	private Integer id;
	private String cognome;
	private String nome;
	private String codiceFiascale;;
	private String email;

}
