package com.lguerrerodev03.figure_mapper_api;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FigureMapperApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigureMapperApiApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Verificar si las variables de entorno están disponibles
		System.out.println("DB URL: " + System.getenv("DB_URL_AZURE"));
		System.out.println("DB Username: " + System.getenv("DB_USERNAME_AZURE"));
		System.out.println("JWT Secret Key: " + System.getenv("JWT_SECRET_KEY"));
	}
}
