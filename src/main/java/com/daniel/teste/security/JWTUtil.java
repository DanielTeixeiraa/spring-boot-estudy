package com.daniel.teste.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username) //USUARIO
				.setExpiration(new Date(System.currentTimeMillis() + expiration)) //HORARIO DO SISTEMA + EXPIRAÇAO
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) //FAZER O TOKEN
				.compact(); //FINALIZAR
	}
}