package com.daniel.teste.models;

import java.io.Serializable;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public Categoria(){
		
	}
	public Categoria(String nome) {
		super();
		this.nome = nome;
		
	}
	
}
