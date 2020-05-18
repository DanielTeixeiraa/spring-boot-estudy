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
import com.daniel.teste.models.Cliente;
import com.daniel.teste.repositories.ClienteRepository;
import com.daniel.teste.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	@GetMapping
	public ResponseEntity<?> listarClientes() {
	return new ResponseEntity<>(clienteRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUm(@PathVariable("id") Integer id) {
		verifyIfClienteExists(id);
		Cliente obj = service.find(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(service.save(cliente),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		verifyIfClienteExists(id);
		service.find(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(service.update(cliente),HttpStatus.OK);
	}
		
	private void verifyIfClienteExists(Integer id) {
		if(service.find(id) ==null) {
			throw new ResourceNotFoundException("Cliente nao econtrada");
	}}
}