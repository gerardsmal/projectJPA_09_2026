package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AbbonamentoReq {
	@NotNull(groups = {ValidationGroup.Update.class, ValidationGroup.Attivita.class} , message = "abbo-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "abbo-no-data" )	
	private LocalDate dataAbbonamento;
	
	private Integer durataAbbonamento;
	
	@NotNull(groups = {ValidationGroup.Create.class , ValidationGroup.Update.class} , message = "socio-no-id" )	
	private Integer socioID;
	
	@NotNull(groups = ValidationGroup.Attivita.class , message = "abb-no-attivita" )	
	private Integer attivitaID;
	

}
