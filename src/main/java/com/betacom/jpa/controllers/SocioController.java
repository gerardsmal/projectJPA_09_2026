package com.betacom.jpa.controllers;

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

import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/socio")
public class SocioController {

	private final AbbonamentoController abbonamentoController;
	private final ISocioServices socioS;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(@RequestParam (required = false)  Integer id,
			@RequestParam (required = false)  String nome,
			@RequestParam (required = false)  String cognome,
			@RequestParam (required = false)  Integer attivita		
			) throws Exception{
		return ResponseEntity.ok(socioS.list(id, nome, cognome, attivita));
	}
	
	@GetMapping("/listByCognome")
	public ResponseEntity<Object> listByCognome(@RequestParam String cognome)
			throws Exception{

		return ResponseEntity.ok(socioS.listByCognome(cognome));
	}

	@GetMapping("/listByAttivita")
	public ResponseEntity<Object> listByAttivita(@RequestParam Integer attivitaID)
						throws Exception{
			return ResponseEntity.ok(socioS.listByAttivita(attivitaID));
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
						@Validated(ValidationGroup.Create.class)
						@RequestBody SocioReq req) throws Exception{
		socioS.create(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
						@Validated(ValidationGroup.Update.class)
						@RequestBody SocioReq req) throws Exception{
			socioS.update(req);
			return ResponseEntity.ok(ResponseDTO.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception{
		socioS.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}

}
