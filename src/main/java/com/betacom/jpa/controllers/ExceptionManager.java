package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {
	
	private final IMessaggioServices msgS;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handlerException(Exception e){
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder()
						.msg(msgS.get(e.getMessage()))
						.build()
						);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO>handlerValidationExeption(MethodArgumentNotValidException e){
		  String msg = e.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .findFirst()
	                .map(FieldError::getDefaultMessage)
	                .orElse("Errore di validazione");
		  
		  return ResponseEntity.badRequest()
				  .body(ResponseDTO.builder()
						  .msg(msgS.get(msg))
						  .build()
						  );

	}
}
