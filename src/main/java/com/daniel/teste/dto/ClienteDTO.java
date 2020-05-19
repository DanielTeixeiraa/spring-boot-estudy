package com.daniel.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.daniel.teste.models.Cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Nome vazio")
	@Length(min=5, max=70, message = "Colocar um nome com tamanho minino de 5 letras e maximo 70")
	private String nome;
	@NotEmpty(message = "Email vazio")
	@Email(message = "Email invalido")
	private String email;
	
	public ClienteDTO (Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
	
}
