package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.UtenteReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IUtenteServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/utente")
public class UtenteController {
	
	private final IUtenteServices utS;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
						@Validated(ValidationGroup.Create.class)
						@RequestBody UtenteReq req) throws Exception{
		utS.create(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> list()
						throws Exception{
			return ResponseEntity.ok(utS.list());
	}
}
