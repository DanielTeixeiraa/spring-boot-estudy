package com.daniel.teste;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.teste.models.Cidade;
import com.daniel.teste.models.Estado;
import com.daniel.teste.repositories.CidadeRepository;
import com.daniel.teste.repositories.EstadoRepository;



@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

//	//@Autowired
//	//private CategoriaRepository categoriaRepository;
//	//@Autowired
//	//private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado es1 = new Estado(null,"minas");
		Estado es2 = new Estado(null,"Sp");
		
		Cidade c1 = new Cidade(null,"Uberlandia",es1);
		Cidade c2 = new Cidade(null,"sao paulo",es2);
		Cidade c3 = new Cidade(null,"campinas",es2);
		
		es1.getCidades().addAll(Arrays.asList(c2,c3));
		es2.getCidades().addAll(Arrays.asList(c1));
		
		estadoRepository.saveAll(Arrays.asList(es1,es2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
//		Categoria cat1 = new Categoria(null, "Informática");
//		Categoria cat2 = new Categoria(null, "Escritório");
//		
//		Produto p1 = new Produto(null, "Computador", 2000.00);
//		Produto p2 = new Produto(null, "Impressora", 800.00);
//		Produto p3 = new Produto(null, "Mouse", 80.00);
//		
//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
//		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
//
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}