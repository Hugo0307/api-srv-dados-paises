package com.hhsa.api.paisesapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {

	private Id id;
    private Nome nome;
    private Area area;
    private Localizacao localizacao;
    private ArrayList<Lingua> linguas;
    private Governo governo;
    @JsonProperty("unidades-monetarias") 
    private ArrayList<UnidadesMonetaria> unidadesMonetarias;
    private String historico;
    
	public Id getId() {
		return id;
	}
	public Nome getNome() {
		return nome;
	}
	public Area getArea() {
		return area;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public ArrayList<Lingua> getLinguas() {
		return linguas;
	}
	public Governo getGoverno() {
		return governo;
	}
	public ArrayList<UnidadesMonetaria> getUnidadesMonetarias() {
		return unidadesMonetarias;
	}
	public String getHistorico() {
		return historico;
	}
    
}
