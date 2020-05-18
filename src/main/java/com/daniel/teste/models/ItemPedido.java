package com.daniel.teste.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ItemPedido {
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	@EmbeddedId //USADA NA CHAVE COMPOSTA
	@JsonIgnore
	private ItemPedido_PK id = new ItemPedido_PK();

	public ItemPedido(Pedido pedido,Produto produto,Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);  //Instanciar o chave PK
		id.setProduto(produto); //Instanciar o chave PK
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonManagedReference
	public Produto getProduto() {
		return id.getProduto();
	}
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	
}
