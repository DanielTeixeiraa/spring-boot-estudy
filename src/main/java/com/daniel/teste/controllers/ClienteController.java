package com.daniel.teste.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daniel.teste.dto.ClienteDTO;
import com.daniel.teste.dto.ClienteNewDTO;
import com.daniel.teste.enums.Perfil;
import com.daniel.teste.error.AuthorizationException;
import com.daniel.teste.error.ResourceNotFoundException;
import com.daniel.teste.models.Cliente;
import com.daniel.teste.repositories.ClienteRepository;
import com.daniel.teste.security.UserSS;
import com.daniel.teste.services.ClienteService;
import com.daniel.teste.services.UserService;

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
	public ResponseEntity<?> listarCliente() {
		List<Cliente> list = clienteRepository.findAll();
		List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
	return new ResponseEntity<>(listDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/page")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> listarClientePage(  //PAGINAÇAO
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			) {
		Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
		return new ResponseEntity<>(listDto,HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUma(@PathVariable("id") Integer id) {
		UserSS user = UserService.authenticated();
		if(user == null || !user.HasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		verifyIfClienteExists(id);
		Cliente obj = service.find(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody ClienteNewDTO dto) {
		Cliente obj = service.fromDTO(dto);
		return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		verifyIfClienteExists(id);
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ClienteDTO dto, @PathVariable Integer id) {
		Cliente obj = service.fromDTO(dto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
		
	private void verifyIfClienteExists(Integer id) {
		if(service.find(id) ==null) {
			throw new ResourceNotFoundException("Caregoria nao econtrada");
	}
		}
	
	@RequestMapping(value="/picture", method=RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
	
}