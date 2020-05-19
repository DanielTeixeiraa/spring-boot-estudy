package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniel.teste.dto.ClienteDTO;
import com.daniel.teste.dto.ClienteNewDTO;
import com.daniel.teste.enums.TipoCliente;
import com.daniel.teste.error.DataIntegrityException;
import com.daniel.teste.models.Cidade;
import com.daniel.teste.models.Cliente;
import com.daniel.teste.models.Endereco;
import com.daniel.teste.repositories.ClienteRepository;
import com.daniel.teste.repositories.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente save(Cliente cliente) {
		cliente.setId(null);
		Cliente obj = clienteRepository.save(cliente);
		enderecoRepository.saveAll(obj.getEndecos());
		return obj;	
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
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
	
		public Cliente FromClienteDto(ClienteDTO objDto) {
			return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null);
		}
		public Cliente FromClienteDto(ClienteNewDTO objDto) {
			Cliente cli = new Cliente(null,objDto.getNome(),objDto.getEmail(),objDto.getCpfOuCnpj(),TipoCliente.toEnum(objDto.getTipo()));
			Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
			Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cid, cli);
			cli.getEndecos().add(end);
			cli.getNumero().add(objDto.getTelefone1());
			if (objDto.getTelefone2()!=null) {
				cli.getNumero().add(objDto.getTelefone2());
			}
			if (objDto.getTelefone3()!=null) {
				cli.getNumero().add(objDto.getTelefone3());
			}
			return cli;
		}
		
		private void updateData(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}
}