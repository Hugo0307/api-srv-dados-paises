package com.hhsa.api.paisesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhsa.api.paisesapi.model.PaisCustomizado;
import com.hhsa.api.paisesapi.service.PaisService;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController {
	
	@Autowired
	private PaisService service;

	@GetMapping
	public ResponseEntity<List<PaisCustomizado>> listarPaises() {
		return ResponseEntity.ok(service.listarPaises());
	}
	
	@GetMapping("/sigla/{sigla}")
	public ResponseEntity<PaisCustomizado> buscarPaisPorSigla(@PathVariable String sigla) {
		return ResponseEntity.ok(service.buscarPaisPorSigla(sigla));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<PaisCustomizado> buscarPaisPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(service.buscarPaisPorNome(nome));
	}
	
	@GetMapping("/continente/{continente}")
	public ResponseEntity<List<PaisCustomizado>> listarPaisesPorContinente(@PathVariable String continente) {
		return ResponseEntity.ok(service.listarPaisesPorContinente(continente));
	}
}
