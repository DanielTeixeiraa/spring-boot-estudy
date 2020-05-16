package com.daniel.teste.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaDao;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaDao.findById(id);
		return obj.orElse(null);
	}
	public Categoria salvar(Categoria categoria) {
		Categoria cat = categoriaDao.save(categoria);
		return cat;	
	}
	public void delete(Integer id) {
		categoriaDao.deleteById(id);
	}
	public Categoria update(Categoria categoria) {
		Categoria cat = categoriaDao.save(categoria);
		return cat;	
	}
}
