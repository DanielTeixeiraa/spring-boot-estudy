package com.daniel.teste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.teste.error.ResourceNotFoundException;
import com.daniel.teste.models.Pedido;
import com.daniel.teste.repositories.PedidoRepository;
import com.daniel.teste.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	private final PedidoRepository pedidoRepository;

	@Autowired
	private PedidoService service;

	@Autowired
	public PedidoController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping
	public ResponseEntity<?> listarCategoria() {
		return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUm(@PathVariable("id") Integer id) {
		verifyIfPedidoExists(id);
		Pedido obj = service.find(id);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(service.save(pedido), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		verifyIfPedidoExists(id);
		service.find(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(service.update(pedido), HttpStatus.OK);
	}

	private void verifyIfPedidoExists(Integer id) {
		if (service.find(id) == null) {
			throw new ResourceNotFoundException("Pedido nao encontrado");
		}
	}

}