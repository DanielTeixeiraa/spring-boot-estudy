package com.daniel.teste.error;

@SuppressWarnings("serial")
public class AuthorizationException extends RuntimeException {

	public AuthorizationException(String mensage) {
		super(mensage);
	}
	public AuthorizationException(String mensage,Throwable cause) {
		super(mensage,cause);
	}
		

}
