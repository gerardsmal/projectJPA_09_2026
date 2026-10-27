package com.betacom.jpa.dto.output;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AbbonamentoDTO {
	private Integer id;
	private LocalDate dataAbbonamento;
	private Integer durataAbbonamento;

}
