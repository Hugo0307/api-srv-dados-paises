package com.hhsa.api.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Localizacao{
	
    private Regiao regiao;
    @JsonProperty("sub-regiao") 
    private SubRegiao subRegiao;
    @JsonProperty("regiao-intermediaria") 
    private RegiaoIntermediaria regiaoIntermediaria;
    
}

