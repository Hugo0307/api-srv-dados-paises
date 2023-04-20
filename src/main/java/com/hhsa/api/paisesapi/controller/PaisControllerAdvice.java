package com.hhsa.api.paisesapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hhsa.api.paisesapi.exception.BadRequestException;
import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;

@ControllerAdvice
public class PaisControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ErroNaOperacaoException.class)
	public ResponseEntity<Object> capturaErroOperacaoRequisicao() {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", "Houve um erro de operação ao requisitar a API externa.");
		
		return ResponseEntity.internalServerError().body(body);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> capturaErroBadRequest() {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", "Pesquisa inválida.");
		
		return ResponseEntity.badRequest().body(body);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> capturaErroNotFound() {
		return new ResponseEntity<Object>("Sem dados a exibir. Verifique sua pesquisa.", HttpStatus.NOT_FOUND);
	}
	
}
