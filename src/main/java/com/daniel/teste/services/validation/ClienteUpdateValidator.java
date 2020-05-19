package com.daniel.teste.services.validation;



import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.daniel.teste.dto.ClienteDTO;
import com.daniel.teste.error.FieldMessage;
import com.daniel.teste.models.Cliente;
import com.daniel.teste.repositories.ClienteRepository;



public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		


		
		//LISTA DE ERROS
		List<FieldMessage> list = new ArrayList<>();
		
		//FAZENDO COMPARAÇAO
		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if(aux != null && aux.getEmail() != objDto.getEmail()) {
			list.add(new FieldMessage("email", "Email já existe"));
			}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}