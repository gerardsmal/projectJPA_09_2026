package com.betacom.jpa.dto.input;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PersoneReq {

	@NotNull(groups = {ValidationGroup.Update.class, ValidationGroup.Attivita.class} , message = "Manca l'id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "Manca il nome" )	
	private String nome;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "Manca il cognome" )	
	private String cognome;	
	@NotNull(groups = ValidationGroup.Create.class , message = "Manca la mail" )	
	private String email;
	private String colore;
}
