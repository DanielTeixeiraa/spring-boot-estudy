package com.daniel.teste.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.daniel.teste.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //fazer herança JOINED=UMA TABELA PARA CADA 
public class Pagamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private EstadoPagamento estadoPagamento;
	
	@OneToOne
	@JoinColumn(name="Pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.pedido = pedido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
