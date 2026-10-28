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
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/attivita")
public class AttivitaController {

	private final IAttivitaServices attS;
	
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(@RequestBody AttivitaReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.CREATED;		
		try {
			attS.create(req);
			r.setMsg("create sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody AttivitaReq req){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			attS.update(req);
			r.setMsg("update sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@DeleteMapping("delete/{attivitaID}")
	public ResponseEntity<ResponseDTO> delete(
			@PathVariable Integer attivitaID){
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;		
		try {
			attS.delete(attivitaID);
			r.setMsg("delete sucessfull");
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}

	@GetMapping("list")
	public ResponseEntity<Object> list(){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r=attS.list();
		} catch (Exception e) {
			log.error("Error {}", e.getMessage());
			status = HttpStatus.BAD_REQUEST;
			r=e.getMessage();
		}
		return ResponseEntity.status(status).body(r);
	}
}
