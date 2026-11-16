package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UtenteReq {
	
	@NotNull(groups = {ValidationGroup.Update.class, ValidationGroup.Create.class} , message = "User name non presente" )		
	private String userName;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "Password non presente" )		
	private String pwd;
	private String email;
	
	@NotNull(groups = ValidationGroup.Create.class , message = "Role non presente" )	
	private String role;
}
