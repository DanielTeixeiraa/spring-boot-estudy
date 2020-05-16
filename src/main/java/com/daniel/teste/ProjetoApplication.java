package com.daniel.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.teste.models.Categoria;
import com.daniel.teste.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaDao;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("daniel");
		Categoria cat2 = new Categoria("andre");
		Categoria cat3 = new Categoria("ben");
		categoriaDao.saveAll(Arrays.asList(cat1, cat2, cat3)); 
	}

}
