package com.daniel.teste.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum EstadoPagamento {
	
	PENDENTE(1,"Pedente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private Integer cod;
	private String descricao;
	
	private EstadoPagamento(Integer cod, String descricao) {
		this.descricao = descricao;
		this.cod = cod;
	}
	
	//Transformar o Enum de String para Numero
	public static EstadoPagamento toEnum(Integer id) {

		 if (id == null) {
		 return null;
		 }

		 for (EstadoPagamento x : EstadoPagamento.values()) {
		 if (id.equals(x.getCod())) {
		 return x;
		 }
		 }
		 throw new IllegalArgumentException("Id inválido " + id);
		 }
		} 

	
	
	

