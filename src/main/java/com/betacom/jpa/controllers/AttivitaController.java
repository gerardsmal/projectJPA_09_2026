package com.betacom.jpa.controllers;

import com.betacom.jpa.services.implmentations.AbbonamentoImpl;
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
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {

	private final AbbonamentoImpl abbonamentoImpl;
	private final AbbonamentoController abbonamentoController;
	private final IAttivitaServices attS;
		
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
			@Validated(ValidationGroup.Create.class)
			@RequestBody AttivitaReq req) throws Exception{

		attS.create(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("create sucessfull")
				.build()
				);	
		}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
			@Validated(ValidationGroup.Update.class)
			@RequestBody AttivitaReq req) throws Exception{
			
		attS.update(req);			
		return ResponseEntity.ok(ResponseDTO.builder()
					.msg("update sucessfull")
					.build()
					);
		}
	
	@DeleteMapping("delete/{attivitaID}")
	public ResponseEntity<ResponseDTO> delete(
			@PathVariable Integer attivitaID) throws Exception{
	
		attS.delete(attivitaID);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}

	@GetMapping("list")
	public ResponseEntity<Object> list() throws Exception{
		return ResponseEntity.ok(attS.list());
	}
}
