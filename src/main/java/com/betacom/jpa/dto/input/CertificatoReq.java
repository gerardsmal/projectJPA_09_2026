package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CertificatoReq {
	private Boolean tipo;  // false normale true agonistico
	@NotNull(groups = {ValidationGroup.Create.class , ValidationGroup.Update.class} , message = "certif-no-data" )	
	private LocalDate dataCerticifato;
	
	@NotNull(groups = {ValidationGroup.Create.class , ValidationGroup.Update.class} , message = "socio-no-id" )	
	private Integer socioID;
}
