package com.daniel.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.daniel.teste.models.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Nome vazio")
	@Length(min=5, max=70, message = "Colocar um nome com tamanho minino de 5 letras e maximo 70")
	private String nome;
	
	
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
}
