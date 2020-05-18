package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.Pagamento;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
