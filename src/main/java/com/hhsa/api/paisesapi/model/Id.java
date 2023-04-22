package com.hhsa.api.paisesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Id{
    @JsonProperty("M49") 
    private int m49;
    @JsonProperty("ISO-3166-1-ALPHA-2") 
    private String iSO31661ALPHA2;
    @JsonProperty("ISO-3166-1-ALPHA-3") 
    private String iSO31661ALPHA3;
    @JsonProperty("ISO-639-1") 
    private String iSO6391;
    @JsonProperty("ISO-639-2") 
    private String iSO6392;
    @JsonProperty("ISO-4217-ALPHA") 
    private String iSO4217ALPHA;
    @JsonProperty("ISO-4217-NUMERICO") 
    private String iSO4217NUMERICO;
    
}
