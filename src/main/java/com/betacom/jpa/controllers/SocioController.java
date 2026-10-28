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

import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/socio")
public class SocioController {

	private final ISocioServices socioS;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r=socioS.list();
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r=e.getMessage();
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@GetMapping("/listByCognome")
	public ResponseEntity<Object> listByCognome(@RequestParam String cognome){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r=socioS.listByCognome(cognome);
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r=e.getMessage();
		}
		return ResponseEntity.status(status).body(r);
	}

	@GetMapping("/listByAttivita")
	public ResponseEntity<Object> listByAttivita(@RequestParam Integer attivitaID){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r=socioS.listByAttivita(attivitaID);
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r=e.getMessage();
		}
		return ResponseEntity.status(status).body(r);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(@RequestBody SocioReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.CREATED;		
		try {
			socioS.create(req);
			r.setMsg("create sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody SocioReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			socioS.update(req);
			r.setMsg("update sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			socioS.delete(id);
			r.setMsg("delete sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}

}
