package com.daniel.teste.handle;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.teste.error.DataIntegrityException;
import com.daniel.teste.error.ResourceNotFoundDetails;
import com.daniel.teste.error.ResourceNotFoundException;
import com.daniel.teste.error.StandardError;
import com.daniel.teste.error.ValidationError;

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
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<?> DataIntegrityException(DataIntegrityException rnfException, HttpServletRequest request){
		ResourceNotFoundDetails details = ResourceNotFoundDetails.builder()
				.withTimestamp(new Date().getTime())
				.withStatus(HttpStatus.BAD_REQUEST.value())
				.withTitle("Resouce not found")
				.withDetail(rnfException.getMessage())
				.withDeveloperMessage(rnfException.getClass().getName())
				.build();
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
