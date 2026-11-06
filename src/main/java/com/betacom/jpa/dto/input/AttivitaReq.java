package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AttivitaReq {
	@NotNull(groups = ValidationGroup.Update.class , message = "attiv-no-id" )		
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "attiv-no-desc" )	
	@NotBlank(groups = ValidationGroup.Create.class , message = "attiv-no-desc" )	
	private String descrizione;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "attiv-no-price" )
	@PositiveOrZero (groups = {ValidationGroup.Create.class, ValidationGroup.Update.class} ,message = "attiv-price-invalid")
	private Long prezzo;

}
