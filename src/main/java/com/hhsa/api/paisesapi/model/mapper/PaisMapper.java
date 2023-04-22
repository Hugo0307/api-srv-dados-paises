package com.hhsa.api.paisesapi.model.mapper;

import java.util.Objects;
import java.util.Optional;

import com.hhsa.api.paisesapi.model.Pais;
import com.hhsa.api.paisesapi.model.PaisCustomizado;

public class PaisMapper {
	
	public static PaisCustomizado map(Optional<Pais> pais) {
		if(Objects.isNull(pais)) return null;
		
		return PaisCustomizado.builder()
				.nome(pais.get().getNome().getAbreviado())
				.sigla(pais.get().getId().getISO31661ALPHA2())
				.idioma(pais.get().getLinguas().get(0).getNome())
				.capital(pais.get().getGoverno().getCapital().getNome())
				.unidadeMonetaria(pais.get().getUnidadesMonetarias().get(0).getNome())
				.regiao(pais.get().getLocalizacao().getRegiao().getNome())
				.subRegiao(pais.get().getLocalizacao().getSubRegiao().getNome())
				.regiaoIntermediaria(getRegiaoIntermediariaNome(pais))
				.areaTotal(pais.get().getArea().getTotal())
				.unidadeMedidaArea(pais.get().getArea().getUnidade().getSímbolo())
				.historico(pais.get().getHistorico())
				.build();
	}
	
	private static String getRegiaoIntermediariaNome(Optional<Pais> pais) {
		
		if(Objects.isNull(pais.get().getLocalizacao().getRegiaoIntermediaria())) {
			return "Não informado.";
		} 
		
		return pais.get().getLocalizacao().getRegiaoIntermediaria().getNome();
	}

}
