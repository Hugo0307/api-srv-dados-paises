package com.hhsa.api.paisesapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {
	
	@Autowired
	private InfoProperties properties;

    @Bean
    OpenAPI springDocOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title(properties.title)
						.description(properties.description)
						.version(properties.version));
	}
}
