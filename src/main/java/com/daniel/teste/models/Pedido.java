package com.daniel.teste.models;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	//POR CAUSA DE SER DATA
	@Temporal(TemporalType.TIMESTAMP) 
	private Date instante;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	@JsonBackReference
	private Cliente cliente;
	
	@JsonManagedReference
	@OneToOne(cascade =CascadeType.ALL, mappedBy = "pedido") //Relacionamento 1 para 1. os dois vao ter o mesmo Id
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	public Pedido(Integer id, Date instante, Cliente cliente, Endereco endereco) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.endereco = endereco;
	}
	
	public List<Pedido> getPedido(){  //PERCORRER UMA LISTA DE PRODUTOS ATRAVES DA ITEMPEDIDO
		List<Pedido> list = new ArrayList<>();
		for(ItemPedido p: itens) {
			list.add(p.getPedido());
		}
		return list;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
