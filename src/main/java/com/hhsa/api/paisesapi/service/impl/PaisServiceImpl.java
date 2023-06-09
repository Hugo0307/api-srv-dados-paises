package com.hhsa.api.paisesapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhsa.api.paisesapi.client.IbgeClient;
import com.hhsa.api.paisesapi.exception.NotFoundException;
import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisCustomizado;
import com.hhsa.api.paisesapi.model.mapper.PaisMapper;
import com.hhsa.api.paisesapi.service.PaisService;


@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	private IbgeClient client;
	
	@Override
	public List<PaisCustomizado> listarPaises() {
		
		return dadosPaises().stream()
				.map(p -> PaisMapper.map(Optional.of(p)))
				.toList();
	}

	@Override
	public PaisCustomizado buscarPaisPorSigla(String sigla) {
		Optional<Pais> paisOptional = Optional.of(client.getPais(sigla.toUpperCase())
				.stream()
				.findFirst()
				.orElseThrow(() -> new NotFoundException(sigla)));
				
		return PaisMapper.map(paisOptional);
	}

	@Override
	public PaisCustomizado buscarPaisPorNome(String nome) {
		
		Optional<Pais> paisOptional = Optional.of(dadosPaises().stream()
				.filter(p -> p.getNome().getAbreviado().equalsIgnoreCase(nome))
				.findFirst()
				.orElseThrow(() -> new NotFoundException(nome)));
		
		return PaisMapper.map(paisOptional);
	}
	
	@Override
	public List<PaisCustomizado> listarPaisesPorContinente(String continente) {
		
		List<PaisCustomizado> paises = dadosPaises().stream()
			.filter(p -> p.getLocalizacao().getRegiao().getNome().equalsIgnoreCase(continente))
			.map(p -> PaisMapper.map(Optional.of(p)))
			.toList();
		
		if(paises.isEmpty()) throw new NotFoundException(continente);
		
		return paises;
	}
	
	private List<Pais> dadosPaises() {
		return client.getPaises();
	}
	
}
