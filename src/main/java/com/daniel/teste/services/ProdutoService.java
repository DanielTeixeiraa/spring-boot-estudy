package com.daniel.teste.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniel.teste.models.Categoria;
import com.daniel.teste.models.Produto;
import com.daniel.teste.repositories.CategoriaRepository;
import com.daniel.teste.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository service;
	@Autowired
	private CategoriaRepository categoriaRepository;

			public Produto find(Integer id) {
			Optional<Produto> obj = service.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName(), null));
		}	
			//FAZENDO PAGINAÇAO DOS PRODUTOS ATRAVES DA QUERE
			public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
				PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
				List<Categoria> categorias = categoriaRepository.findAllById(ids);
				return service.seach(nome, categorias, pageRequest);	
			}
		
}