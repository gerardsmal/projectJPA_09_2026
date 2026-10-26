package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CertificatoReq {
	private Boolean tipo;  // false normale true agonistico
	private LocalDate dataCerticifato;
	private Integer socioID;
}
