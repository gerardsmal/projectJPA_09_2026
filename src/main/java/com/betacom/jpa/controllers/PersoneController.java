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

import com.betacom.jpa.dto.input.PersoneReq;
import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IPersoneServices;
import com.betacom.jpa.services.interfaces.IUtenteServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/persone")
public class PersoneController {
	
	private final IPersoneServices perS;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
						@Validated(ValidationGroup.Create.class)
						@RequestBody PersoneReq req) throws Exception{
		perS.create(req);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
						@Validated(ValidationGroup.Update.class)
						@RequestBody PersoneReq req) throws Exception{
		perS.update(req);
			return ResponseEntity.ok(ResponseDTO.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception{
		perS.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}

	@GetMapping("/list")
	public ResponseEntity<Object> list()
						throws Exception{
			return ResponseEntity.ok(perS.list());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Object> getById(@RequestParam Integer id)
						throws Exception{
			return ResponseEntity.ok(perS.getById(id));
	}

}
