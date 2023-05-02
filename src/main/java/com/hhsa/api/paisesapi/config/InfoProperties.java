package com.hhsa.api.paisesapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfoProperties {
	
	@Value("${app.name}")
	public String title;
	
	@Value("${app.version}")
	public String version;
	
	@Value("${app.description}")
	public String description;
	

}
