package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginReq {
	@NotNull(groups = ValidationGroup.Create.class , message = "UserName/Password invalido" )
	private String userName;
	@NotNull(groups = ValidationGroup.Create.class , message = "UserName/Password invalido" )
	private String password;
}
