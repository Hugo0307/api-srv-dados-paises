package com.hhsa.api.paisesapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
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
    
}
