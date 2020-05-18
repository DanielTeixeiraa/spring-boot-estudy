package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
