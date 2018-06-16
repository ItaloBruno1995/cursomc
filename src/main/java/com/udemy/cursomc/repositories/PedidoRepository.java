package com.udemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.udemy.cursomc.domain.Pedido;

@Repository                                              //CLASS     //TIPO ID
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	
	
}
