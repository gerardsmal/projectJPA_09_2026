package com.betacom.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ResponseDTO> create(@RequestBody AbbonamentoReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.CREATED;		
		try {
			abbS.create(req);
			r.setMsg("create sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody AbbonamentoReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			abbS.update(req);
			r.setMsg("update sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@DeleteMapping("delete/{abboID}/{socioID}")
	public ResponseEntity<ResponseDTO> delete(
			@PathVariable Integer abboID,
			@PathVariable Integer socioID){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			abbS.delete(abboID, socioID);
			r.setMsg("delete sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}

	@PostMapping("createAbbonamentoAttivita")
	public ResponseEntity<ResponseDTO> createAbbonamentoAttivita(@RequestBody AbbonamentoReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.CREATED;		
		try {
			abbS.createAbbonamentoAttivita(req);
			r.setMsg("create sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@DeleteMapping("deleteAbbonamentoAttivita/{abboID}/{attivitaID}")
	public ResponseEntity<ResponseDTO> deleteAbbonamentoAttivita(
			@PathVariable Integer abboID,
			@PathVariable Integer attivitaID){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			abbS.deleteAbbonamentoAttivita(abboID, attivitaID);
			r.setMsg("delete sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@GetMapping("listBySocio")
	public ResponseEntity<Object> listBySocio(@RequestParam Integer socioID){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r=abbS.listBySocio(socioID);
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r=e.getMessage();
		}
		return ResponseEntity.status(status).body(r);
	}

}
