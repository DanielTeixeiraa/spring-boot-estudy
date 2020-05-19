package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniel.teste.dto.ClienteDTO;
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
		Cliente obj = clienteRepository.save(cliente);
		return obj;	
	}
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
		
		}
	
		public Cliente FromClienteDto(ClienteDTO dto) {
			return new Cliente(dto.getId(),dto.getNome(),dto.getEmail(),null,null);
		}
		
		private void updateData(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}
}