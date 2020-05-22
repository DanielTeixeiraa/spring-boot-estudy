package com.daniel.teste.enums;

import lombok.Getter;

@Getter
public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	private Integer cod;
	private String descricao;
	
	private Perfil(Integer cod, String descricao) {
		this.descricao = descricao;
		this.cod = cod;
	}
	
	//Transformar o Enum de String para Numero
	public static Perfil toEnum(Integer id) {

		 if (id == null) {
		 return null;
		 }

		 for (Perfil x : Perfil.values()) {
		 if (id.equals(x.getCod())) {
		 return x;
		 }
		 }
		 throw new IllegalArgumentException("Id inválido " + id);
		 }
		} 

	
	
	