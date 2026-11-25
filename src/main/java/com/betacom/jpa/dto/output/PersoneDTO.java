package com.betacom.jpa.dto.output;

import com.betacom.jpa.dto.input.ValidationGroup;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersoneDTO {
private Integer id;
	private String nome;
	private String cognome;	
	private String email;
	private String colore;
}
