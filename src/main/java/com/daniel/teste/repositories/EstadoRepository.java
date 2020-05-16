package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
