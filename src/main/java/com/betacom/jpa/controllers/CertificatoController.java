package com.betacom.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.CertificatoReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.ICertificatoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/certificato")
public class CertificatoController {

	private final ICertificatoServices CertS;
	
	
	@PutMapping("update")
	public ResponseEntity<ResponseDTO> update(
			@Validated(ValidationGroup.Create.class)
			@RequestBody CertificatoReq req) throws Exception{
			
		CertS.updateCertificato(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("update certificato sucessfull")
				.build()
				);
	}
}
