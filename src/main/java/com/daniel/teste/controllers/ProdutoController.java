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
import com.daniel.teste.models.Produto;
import com.daniel.teste.repositories.ProdutoRepository;
import com.daniel.teste.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController{
	private final ProdutoRepository produtoRepository;

@Autowired
private ProdutoService service;

@Autowired
public ProdutoController (ProdutoRepository produtoRepository) {
	this.produtoRepository = produtoRepository;
}


@GetMapping
public ResponseEntity<?> listarCategoria() {
return new ResponseEntity<>(produtoRepository.findAll(),HttpStatus.OK);
}

@GetMapping(path = "/{id}")
public ResponseEntity<?> listaUma(@PathVariable("id") Integer id) {
	Produto obj = service.find(id);
	if(obj == null)
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<?> save(@RequestBody Produto produto) {
	return new ResponseEntity<>(service.salvar(produto),HttpStatus.OK);
}

@DeleteMapping(path="/{id}")
public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
	service.find(id);
	return new ResponseEntity<>(HttpStatus.OK);
}

@PutMapping
public ResponseEntity<?> update(@RequestBody Produto produto) {
	return new ResponseEntity<>(service.update(produto),HttpStatus.OK);
}
	
private void verifyIfProdutoExists(Integer id) {
	if(service.find(id) ==null) {
		throw new ResourceNotFoundException("Caregoria nao econtrada");
}}

}