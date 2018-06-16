package com.udemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.udemy.cursomc.domain.ItemPedido;

@Repository                                              //CLASS     //TIPO ID
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	
	
}
