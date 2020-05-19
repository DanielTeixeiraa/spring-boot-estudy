package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.teste.models.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Transactional(readOnly = true) //DEIXA A OPERAÇAO SO PARA LEITURA
	public Cliente findByEmail(String email);
	
}
