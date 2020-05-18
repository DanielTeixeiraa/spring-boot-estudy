package com.daniel.teste.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.teste.models.ItemPedido;



@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
