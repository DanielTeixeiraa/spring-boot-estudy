package com.daniel.teste.config;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBservice db;
	@Bean
	public boolean iniciarDataBase() throws ParseException {
		db.iniciar();
		return true;
	}
}
