package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.Cidade;



@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
