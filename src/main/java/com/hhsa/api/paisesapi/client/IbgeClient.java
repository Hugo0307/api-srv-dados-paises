package com.hhsa.api.paisesapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hhsa.api.paisesapi.model.Pais;

@FeignClient(name = "clients", url = "${clients.url}")
public interface IbgeClient {
	
	@GetMapping
	List<Pais> getPaises();

}
