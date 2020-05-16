package com.daniel.teste.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;
import com.daniel.teste.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	private final CategoriaRepository categoriaDao;
	
	@Autowired
	private CategoriaService service;
	
	@Autowired
	public CategoriaController(CategoriaRepository categoriaDao) {
		this.categoriaDao = categoriaDao;
	}
	
	
	@GetMapping
	public ResponseEntity<?> listarCategoria() {
		Categoria cat1 = new Categoria("Daniel");
		Categoria cat2 = new Categoria("Andre");
		List<Categoria> catlist = new ArrayList<>();
		catlist.add(cat1);
		catlist.add(cat2);
	return new ResponseEntity<>(categoriaDao.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUma(@PathVariable("id") Integer id) {
		Categoria obj = service.buscar(id);
		if(obj == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(service.salvar(categoria),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.buscar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(service.update(categoria),HttpStatus.OK);
	}
		
	
	
}
