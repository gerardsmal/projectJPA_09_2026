package com.betacom.jpa.dto.output;

import java.time.LocalDate;
import java.util.List;

import com.betacom.jpa.models.Attivita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbbonamentoDTO {
	private Integer id;
	private LocalDate dataAbbonamento;
	private Integer durataAbbonamento;
	private List<AttivitaDTO> attivita;

}
