package com.hhsa.api.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Nome{
	
    private String abreviado;
    @JsonProperty("abreviado-EN") 
    private String abreviadoEN;
    @JsonProperty("abreviado-ES") 
    private String abreviadoES;
    
}
