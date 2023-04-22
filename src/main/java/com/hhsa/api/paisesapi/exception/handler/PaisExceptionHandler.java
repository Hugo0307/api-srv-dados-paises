package com.hhsa.api.paisesapi.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;

@ControllerAdvice
public class PaisExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ErroNaOperacaoException.class)
	public ResponseEntity<Map<String, String>> capturaErroOperacaoRequisicao() {
		String mensagem = "Houve um erro de operação ao requisitar a API externa.";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(setMensagem(mensagem));
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> capturaErroNotFound() {
		String mensagem = "Sem dados a exibir. Verifique sua pesquisa.";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(setMensagem(mensagem));
	}
	
	private Map<String, String> setMensagem(String mensagem) {
		Map<String, String> body = new HashMap<String, String>();
		body.put("mensagem", mensagem);
		return body;
	}
	
}
