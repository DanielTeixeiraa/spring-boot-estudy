package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.teste.models.Cliente;
import com.daniel.teste.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente save(Cliente cliente) {
		Cliente cat = clienteRepository.save(cliente);
		return cat;	
	}
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}
	public Cliente update(Cliente cliente) {
		Cliente cat = clienteRepository.save(cliente);
		return cat;	
	}
}