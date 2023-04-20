package com.hhsa.api.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Localizacao{
	
    private Regiao regiao;
    @JsonProperty("sub-regiao") 
    private SubRegiao subRegiao;
    @JsonProperty("regiao-intermediaria") 
    private RegiaoIntermediaria regiaoIntermediaria;
	
    public Regiao getRegiao() {
		return regiao;
	}
	public SubRegiao getSubRegiao() {
		return subRegiao;
	}
	public RegiaoIntermediaria getRegiaoIntermediaria() {
		return regiaoIntermediaria;
	}
    
}

