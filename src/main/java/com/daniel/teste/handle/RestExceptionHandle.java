package com.daniel.teste.handle;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.teste.error.ResourceNotFoundDetails;
import com.daniel.teste.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandle {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException, HttpServletRequest request){
		ResourceNotFoundDetails details = ResourceNotFoundDetails.builder()
				.withTimestamp(new Date().getTime())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withTitle("Resouce not found")
				.withDetail(rnfException.getMessage())
				.withDeveloperMessage(rnfException.getClass().getName())
				.build();
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
		
	}
	
}
