package com.daniel.teste.controllers;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.teste.dto.CategoriaDTO;
import com.daniel.teste.error.ResourceNotFoundException;
import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;
import com.daniel.teste.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
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
		List<Categoria> list = categoriaRepository.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	return new ResponseEntity<>(listDto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<?> listarCategoriaPage(  //PAGINAÇAO
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			) {
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return new ResponseEntity<>(listDto,HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listaUma(@PathVariable("id") Integer id) {
		verifyIfCategoriaExists(id);
		Categoria obj = service.find(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody CategoriaDTO dto) {
		Categoria obj = service.FromCategoriaDto(dto);
		return new ResponseEntity<>(service.save(obj),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		verifyIfCategoriaExists(id);
		service.find(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody CategoriaDTO dto, @PathVariable Integer id) {
		Categoria obj = service.FromCategoriaDto(dto);
		obj.setId(id);
		return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
	}
		
	private void verifyIfCategoriaExists(Integer id) {
		if(service.find(id) ==null) {
			throw new ResourceNotFoundException("Caregoria nao econtrada");
	}}
	
}
