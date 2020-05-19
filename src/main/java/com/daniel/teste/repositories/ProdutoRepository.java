package com.daniel.teste.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.teste.models.Categoria;
import com.daniel.teste.models.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	@Transactional(readOnly=true)
	//BUSCA NO SQL
	//@Param -> DEFINIR O "NOME" PARA A STRING NOME E "CATEGORIAS" PARA LISTA DE CATEGORIAS
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> seach(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}


