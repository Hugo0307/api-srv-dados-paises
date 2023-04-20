package com.hhsa.api.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nome{
	
    private String abreviado;
    @JsonProperty("abreviado-EN") 
    private String abreviadoEN;
    @JsonProperty("abreviado-ES") 
    private String abreviadoES;
    
	public String getAbreviado() {
		return abreviado;
	}
	public String getAbreviadoEN() {
		return abreviadoEN;
	}
	public String getAbreviadoES() {
		return abreviadoES;
	}
    
}
