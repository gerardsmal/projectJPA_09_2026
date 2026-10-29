package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SocioReq {
	@NotNull(groups = ValidationGroup.Update.class , message = "socio-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "socio-no-cognome" )	
	@NotBlank(groups = ValidationGroup.Create.class , message = "socio-no-cognome" )	
	private String cognome;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "socio-no-nome" )	
	@NotBlank(groups = ValidationGroup.Create.class , message = "socio-no-nome" )
	private String nome;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "socio-cfisc-invalid" )	
	@NotBlank(groups = ValidationGroup.Create.class ,message = "socio-cfisc-invalid" )
	private String codiceFiscale;
	
	@Email (groups = {ValidationGroup.Create.class , ValidationGroup.Update.class} ,message = "socio-email-invalid")
	private String email;
	

}
