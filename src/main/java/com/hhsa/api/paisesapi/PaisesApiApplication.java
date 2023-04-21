package com.hhsa.api.paisesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaisesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisesApiApplication.class, args);
	}

}
