package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniel.teste.dto.CategoriaDTO;
import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Categoria save(Categoria categoria) {
		Categoria obj = categoriaRepository.save(categoria);
		return obj;	
	}
	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}
	public Categoria update(Categoria categoria) {
		Categoria obj = categoriaRepository.save(categoria);
		return obj;	
	}
	//para fazer a paginaçao
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	return categoriaRepository.findAll(pageRequest);
	
	}
	public Categoria FromCategoriaDto(CategoriaDTO dto) {
		return new Categoria(dto.getId(),dto.getNome());
	}
}
