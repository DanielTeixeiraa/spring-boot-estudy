package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
