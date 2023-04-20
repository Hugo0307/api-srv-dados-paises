package com.hhsa.api.paisesapi.model;

public class PaisModificado {

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

	public PaisModificado(String nome, String sigla, String idioma, String capital, String unidadeMonetaria,
			String regiao, String subRegiao, String regiaoIntermediaria, String areaTotal, String unidadeMedidaArea,
			String historico) {
		this.nome = nome;
		this.sigla = sigla;
		this.idioma = idioma;
		this.capital = capital;
		this.unidadeMonetaria = unidadeMonetaria;
		this.regiao = regiao;
		this.subRegiao = subRegiao;
		this.regiaoIntermediaria = regiaoIntermediaria;
		this.areaTotal = areaTotal;
		this.unidadeMedidaArea = unidadeMedidaArea;
		this.historico = historico;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getUnidadeMonetaria() {
		return unidadeMonetaria;
	}
	public void setUnidadeMonetaria(String unidadeMonetaria) {
		this.unidadeMonetaria = unidadeMonetaria;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getSubRegiao() {
		return subRegiao;
	}
	public void setSubRegiao(String subRegiao) {
		this.subRegiao = subRegiao;
	}
	public String getRegiaoIntermediaria() {
		return regiaoIntermediaria;
	}
	public void setRegiaoIntermediaria(String regiaoIntermediaria) {
		this.regiaoIntermediaria = regiaoIntermediaria;
	}
	public String getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}
	public String getUnidadeMedidaArea() {
		return unidadeMedidaArea;
	}
	public void setUnidadeMedidaArea(String unidadeMedidaArea) {
		this.unidadeMedidaArea = unidadeMedidaArea;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	
}
