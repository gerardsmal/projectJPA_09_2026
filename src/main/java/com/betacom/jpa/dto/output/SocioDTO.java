package com.betacom.jpa.dto.output;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SocioDTO {
	private Integer id;
	private String cognome;
	private String nome;
	private String codiceFiascale;;
	private String email;
	private CertificatoDTO certificato;
	private List<AbbonamentoDTO> abbonamento;

}
