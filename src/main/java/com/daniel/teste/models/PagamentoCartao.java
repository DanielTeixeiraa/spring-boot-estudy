package com.daniel.teste.models;

import javax.persistence.Entity;

import com.daniel.teste.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class PagamentoCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	private Integer numerosDePacelas;
	public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer parcelas) {
		super(id, estadoPagamento, pedido);
		this.numerosDePacelas = parcelas;
	}
	
}