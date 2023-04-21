package com.hhsa.api.paisesapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhsa.api.paisesapi.client.IbgeClient;
import com.hhsa.api.paisesapi.exception.BadRequestException;
import com.hhsa.api.paisesapi.exception.ErroNaOperacaoException;
import com.hhsa.api.paisesapi.exception.NotFoundException;
import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisModificado;

import feign.FeignException;

@Service
public class PaisService {
	
	@Autowired
	private IbgeClient client;

	public List<Pais> dadosPaises() {
		List<Pais> paises = new ArrayList<>();
		
		try {
			paises = client.getPaises();
			
		} catch (FeignException e) {
			new ErroNaOperacaoException();
		}
		return paises;
	}

	public PaisModificado buscarPaisPorSigla(String sigla) throws ErroNaOperacaoException, NotFoundException, BadRequestException {
		PaisModificado pais = null;
		
		if(!sigla.trim().equals("")) {
			
				Optional<Pais> paisOptional = Optional.of(dadosPaises().stream()
						.filter(p -> p.getId().getiSO31661ALPHA2().equalsIgnoreCase(sigla))
						.findFirst()
						.orElseThrow(() -> new NotFoundException()));
				
				pais = filtrarPais(paisOptional);
		} else {
			throw new BadRequestException();
		}
		return pais;
	}

	public PaisModificado buscarPaisPorNome(String nome) throws ErroNaOperacaoException, NotFoundException, BadRequestException {
		PaisModificado pais = null;
		
		if(!nome.trim().equals("")) {
			Optional<Pais> paisOptional = Optional.of(dadosPaises().stream()
					.filter(p -> p.getNome().getAbreviado().equalsIgnoreCase(nome))
					.findFirst()
					.orElseThrow(() -> new NotFoundException()));
			
			pais = filtrarPais(paisOptional);
		} else {
			throw new BadRequestException();
		}
		return pais;
	}
	
	private PaisModificado filtrarPais(Optional<Pais> pais) {
		
		String regiaoIntermediariaNome;
		if(pais.get().getLocalizacao().getRegiaoIntermediaria() == null) {
			regiaoIntermediariaNome = "Não informado.";
		} else {
			regiaoIntermediariaNome = pais.get().getLocalizacao().getRegiaoIntermediaria().getNome();
		}
		return new PaisModificado(
				pais.get().getNome().getAbreviado(),
				pais.get().getId().getiSO31661ALPHA2(),
				pais.get().getLinguas().get(0).getNome(),
				pais.get().getGoverno().getCapital().getNome(),
				pais.get().getUnidadesMonetarias().get(0).getNome(),
				pais.get().getLocalizacao().getRegiao().getNome(),
				pais.get().getLocalizacao().getSubRegiao().getNome(),
				regiaoIntermediariaNome,
				pais.get().getArea().getTotal(),
				pais.get().getArea().getUnidade().getSímbolo(),
				pais.get().getHistorico()
				);
	}
	
	public List<String> listarPaisesPorContinente(String continente) throws ErroNaOperacaoException, IOException {

		return dadosPaises().stream()
			.filter(p -> p.getLocalizacao().getRegiao().getNome().equalsIgnoreCase(continente))
			.map(p -> p.getNome().getAbreviado())
			.collect(Collectors.toList());
	}

}
