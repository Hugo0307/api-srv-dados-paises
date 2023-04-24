package com.hhsa.api.paisesapi.service;

import java.util.List;

import com.hhsa.api.paisesapi.model.PaisCustomizado;

public interface PaisService {
	
	PaisCustomizado buscarPaisPorSigla(String sigla);
	
	PaisCustomizado buscarPaisPorNome(String nome);
	
	List<PaisCustomizado> listarPaisesPorContinente(String continente);

	List<PaisCustomizado> listarPaises();

}
