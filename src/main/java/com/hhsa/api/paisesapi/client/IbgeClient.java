package com.hhsa.api.paisesapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhsa.api.paisesapi.model.Pais;

@FeignClient(name = "servico-dados-ibge-paises", url = "${clients.servico-dados-ibge-paises.url}")
public interface IbgeClient {
	
	@GetMapping
	List<Pais> getPaises();
	
	@GetMapping("/{identificador}")
	List<Pais> getPais(@RequestParam String identificador);
	
}
