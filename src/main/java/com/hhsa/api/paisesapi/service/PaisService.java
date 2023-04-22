package com.hhsa.api.paisesapi.service;

import java.util.List;

import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;
import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisCustomizado;

public interface PaisService {
	
	List<Pais> dadosPaises() throws ErroNaOperacaoException;
	
	PaisCustomizado buscarPaisPorSigla(String sigla) throws NotFoundException, ErroNaOperacaoException;
	
	PaisCustomizado buscarPaisPorNome(String nome) throws NotFoundException, ErroNaOperacaoException;
	
	List<PaisCustomizado> listarPaisesPorContinente(String continente) throws NotFoundException, ErroNaOperacaoException;

}
