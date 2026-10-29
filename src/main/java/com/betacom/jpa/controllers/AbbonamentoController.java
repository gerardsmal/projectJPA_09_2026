package com.betacom.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.AbbonamentoReq;
import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/abbonamento")
public class AbbonamentoController {

	private final IAbbonamentoServices abbS;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
			@Validated(ValidationGroup.Create.class) 
			@RequestBody AbbonamentoReq req) throws Exception{

		abbS.create(req);		
		return ResponseEntity.ok(ResponseDTO.builder()
					.msg("create sucessfull")
					.build()
					);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
			@Validated(ValidationGroup.Update.class)
			@RequestBody AbbonamentoReq req) throws Exception{

		abbS.update(req);		
		return ResponseEntity.ok(ResponseDTO.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("delete/{abboID}/{socioID}")
	public ResponseEntity<ResponseDTO> delete(
			@PathVariable Integer abboID,
			@PathVariable Integer socioID) throws Exception{
			
		abbS.delete(abboID, socioID);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}

	@PostMapping("createAbbonamentoAttivita")
	public ResponseEntity<ResponseDTO> createAbbonamentoAttivita(
			@Validated(ValidationGroup.Attivita.class)
			@RequestBody AbbonamentoReq req) throws Exception{
			
		abbS.createAbbonamentoAttivita(req);
		return ResponseEntity.ok(ResponseDTO.builder()
					.msg("create sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("deleteAbbonamentoAttivita/{abboID}/{attivitaID}")
	public ResponseEntity<ResponseDTO> deleteAbbonamentoAttivita(
			@PathVariable Integer abboID,
			@PathVariable Integer attivitaID) throws Exception{

		abbS.deleteAbbonamentoAttivita(abboID, attivitaID);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("attivity delete  sucessfull")
				.build()
				);

	}
	
	@GetMapping("listBySocio")
	public ResponseEntity<Object> listBySocio(@RequestParam Integer socioID) 
				throws Exception {
		return ResponseEntity.ok(abbS.listBySocio(socioID));
	}

}
