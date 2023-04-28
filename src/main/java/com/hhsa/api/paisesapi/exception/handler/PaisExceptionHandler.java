package com.hhsa.api.paisesapi.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hhsa.api.paisesapi.exception.NotFoundException;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class PaisExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, String>> capturaErroOperacaoRequisicao(FeignException e) {
		String mensagem = "Houve um erro de operação ao requisitar a API externa.";
		log.error("### Erro na chamada à API do IBGE: {}", e.getMessage());
		log.error("### Motivo: {}", e.getCause());;
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(setMensagem(mensagem));
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> capturaErroNotFound(NotFoundException e) {
		String mensagem = String.format("Sem dados a exibir. Parâmetro de pesquisa inválido: %s", e.getMessage());
		log.error("### Parâmetro de pesquisa inválido {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(setMensagem(mensagem));
	}
	
	private Map<String, String> setMensagem(String mensagem) {
		Map<String, String> body = new HashMap<String, String>();
		body.put("mensagem", mensagem);
		return body;
	}
	
}
