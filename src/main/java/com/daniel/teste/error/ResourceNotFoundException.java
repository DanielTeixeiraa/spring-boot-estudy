package com.daniel.teste.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String mensage) {
		super(mensage);
	}
	public ResourceNotFoundException(String mensage,Throwable cause) {
		super(mensage,cause);
	}
		

}
