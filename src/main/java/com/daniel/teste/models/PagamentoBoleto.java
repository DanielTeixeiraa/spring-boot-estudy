package com.daniel.teste.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.daniel.teste.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class PagamentoBoleto extends Pagamento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE) 
	private Date dataVencimento;
	@Temporal(TemporalType.DATE) 
	private Date dataPagamento;
	public PagamentoBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dateVencimento, Date datePagamento) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento = datePagamento;
		this.dataVencimento = dateVencimento;
	}
	
}
