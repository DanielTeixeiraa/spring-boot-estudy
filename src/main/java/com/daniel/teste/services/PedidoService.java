package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.teste.models.Pedido;
import com.daniel.teste.repositories.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido find(Integer id) {
		 Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Pedido save(Pedido pedido) {
		Pedido cat = pedidoRepository.save(pedido);
		return cat;	
	}
	public void delete(Integer id) {
		pedidoRepository.deleteById(id);
	}
	public Pedido update(Pedido pedido) {
		Pedido cat = pedidoRepository.save(pedido);
		return cat;	
	}
}
