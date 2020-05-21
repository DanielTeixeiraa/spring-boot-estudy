package com.daniel.teste.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.teste.services.EmailService;
import com.daniel.teste.services.MockEmailService;

@Configuration
@Profile("dev")
//CONFIGURAÇAO DA APLICAÇAO DE DEV
public class DevConfig {
	@Autowired
	private DBservice dba;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean iniciarDataBase() throws ParseException {
		dba.iniciar();
		return true;
	}

	@Bean
	public EmailService emailservice() {
		return new MockEmailService();
	}
}
