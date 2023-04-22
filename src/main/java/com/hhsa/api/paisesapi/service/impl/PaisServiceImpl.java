package com.hhsa.api.paisesapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhsa.api.paisesapi.client.IbgeClient;
import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;
import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisCustomizado;
import com.hhsa.api.paisesapi.model.mapper.PaisMapper;
import com.hhsa.api.paisesapi.service.PaisService;

import feign.FeignException;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private IbgeClient client;

	@Override
	public List<Pais> dadosPaises() throws ErroNaOperacaoException {
		List<Pais> paises = new ArrayList<>();
		
		try {
			paises = client.getPaises();
			
		} catch (FeignException e) {
			throw new ErroNaOperacaoException();
		}
		return paises;
	}

	@Override
	public PaisCustomizado buscarPaisPorSigla(String sigla) throws NotFoundException, ErroNaOperacaoException {
			
		Optional<Pais> paisOptional = Optional.of(dadosPaises().stream()
				.filter(p -> p.getId().getISO31661ALPHA2().equalsIgnoreCase(sigla))
				.findFirst()
				.orElseThrow(() -> new NotFoundException()));
				
		return PaisMapper.map(paisOptional);
	}

	@Override
	public PaisCustomizado buscarPaisPorNome(String nome) throws NotFoundException, ErroNaOperacaoException {
		
		Optional<Pais> paisOptional = Optional.of(dadosPaises().stream()
				.filter(p -> p.getNome().getAbreviado().equalsIgnoreCase(nome))
				.findFirst()
				.orElseThrow(() -> new NotFoundException()));
		
		return PaisMapper.map(paisOptional);
	}
	
	@Override
	public List<PaisCustomizado> listarPaisesPorContinente(String continente) throws NotFoundException, ErroNaOperacaoException {
		
		List<PaisCustomizado> paises = dadosPaises().stream()
			.filter(p -> p.getLocalizacao().getRegiao().getNome().equalsIgnoreCase(continente))
			.map(p -> PaisMapper.map(Optional.of(p)))
			.toList();
		
		if(paises.isEmpty()) throw new NotFoundException();
		
		return paises;
	}
	
}
