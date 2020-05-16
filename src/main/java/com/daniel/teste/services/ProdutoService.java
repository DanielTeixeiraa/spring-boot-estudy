package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.teste.models.Produto;
import com.daniel.teste.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
	public Produto salvar(Produto produto) {
		Produto prod = produtoRepository.save(produto);
		return prod;	
	}
	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}
	public Produto update(Produto produto) {
		Produto prod = produtoRepository.save(produto);
		return prod;	
	}

}
