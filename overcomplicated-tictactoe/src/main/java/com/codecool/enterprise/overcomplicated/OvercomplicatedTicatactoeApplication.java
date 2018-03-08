package com.codecool.enterprise.overcomplicated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OvercomplicatedTicatactoeApplication {
	public static final String FUNFACT_SERVICE_URL = "http://0.0.0.0:60001/";

	public static void main(String[] args) {
		SpringApplication.run(OvercomplicatedTicatactoeApplication.class, args);
	}

}
