package com.daniel.teste.services.validation;
//Checklist:

// Criar a anotação customizada
// Criar o Valitator personalizado para esta anotação e para o nosso DTO
// Programar o Validator, fazendo testes e inserindo as mensagens de erro
// Anotar nosso DTO com a nova anotação criada

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClienteInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteInsert {
	String message() default "Erro de validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}