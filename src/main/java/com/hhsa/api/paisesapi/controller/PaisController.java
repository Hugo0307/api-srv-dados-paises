package com.hhsa.api.paisesapi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhsa.api.paisesapi.exception.BadRequestException;
import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;
import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisCustomizado;
import com.hhsa.api.paisesapi.service.PaisService;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController {
	
	@Autowired
	private PaisService paisesService;

	@GetMapping
	public ResponseEntity<List<Pais>> listarPaises(){
		return ResponseEntity.ok(paisesService.dadosPaises());
	}
	
	@GetMapping("/sigla/{sigla}")
	public ResponseEntity<PaisCustomizado> buscarPaisPorSigla(@PathVariable String sigla) throws ErroNaOperacaoException, NotFoundException, BadRequestException {
		return ResponseEntity.ok(paisesService.buscarPaisPorSigla(sigla));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<PaisCustomizado> buscarPaisPorNome(@PathVariable String nome) throws ErroNaOperacaoException, NotFoundException, BadRequestException {
		return ResponseEntity.ok(paisesService.buscarPaisPorNome(nome));
	}
	
	@GetMapping("/continente/{continente}")
	public ResponseEntity<List<String>> listarPaisesPorContinente(@PathVariable String continente) throws ErroNaOperacaoException, IOException {
		return ResponseEntity.ok(paisesService.listarPaisesPorContinente(continente));
	}
}
