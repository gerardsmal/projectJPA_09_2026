package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AbbonamentoReq {
	private Integer id;
	private LocalDate dataAbbonamento;
	private Integer durataAbbonamento;
	private Integer socioID;

}
