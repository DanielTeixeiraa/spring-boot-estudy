package com.daniel.teste.config;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
//CONFIGURAÇAO DA APLICAÇAO DE DEV
public class DevConfig {
	@Autowired
	private DBservice db;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	@Bean
	public boolean iniciarDataBase() throws ParseException {
		if(!"Create".equals(strategy)) {
			return false;
		}
		db.iniciar();
		return true;
	}
}
