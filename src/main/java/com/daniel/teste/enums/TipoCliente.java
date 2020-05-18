package com.daniel.teste.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
	PESSOA_FISICA(1,"Pessoa fisica"),
	PESSOA_JURIDICA(2,"Pessoa juridica");

	private Integer cod;
	private String descricao;
	
	private TipoCliente(Integer cod, String descricao) {
		this.descricao = descricao;
		this.cod = cod;
	}
	
	//Transformar o Enum de String para Numero
	public static TipoCliente toEnum(Integer id) {

		 if (id == null) {
		 return null;
		 }

		 for (TipoCliente x : TipoCliente.values()) {
		 if (id.equals(x.getCod())) {
		 return x;
		 }
		 }
		 throw new IllegalArgumentException("Id inválido " + id);
		 }
		} 

	
	
	

