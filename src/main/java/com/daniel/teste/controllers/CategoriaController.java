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
import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;
import com.daniel.teste.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService service;
	
	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	
	@GetMapping
	public ResponseEntity<?> listarCategoria() {
	return new ResponseEntity<>(categoriaRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUma(@PathVariable("id") Integer id) {
		verifyIfCategoriaExists(id);
		Categoria obj = service.find(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(service.salvar(categoria),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		verifyIfCategoriaExists(id);
		service.find(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(service.update(categoria),HttpStatus.OK);
	}
		
	private void verifyIfCategoriaExists(Integer id) {
		if(service.find(id) ==null) {
			throw new ResourceNotFoundException("Caregoria nao econtrada");
	}}
	
}
