package com.hhsa.api.paisesapi.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaisCustomizado {
	
	private String nome;
	private String sigla;
	private String idioma;
	private String capital;
	private String unidadeMonetaria;
	private String regiao;
	private String subRegiao;
	private String regiaoIntermediaria;
	private String areaTotal;
	private String unidadeMedidaArea;
	private String historico;
}