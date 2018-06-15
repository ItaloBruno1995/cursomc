package com.udemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udemy.cursomc.domain.Cliente;

@Repository                                              //CLASS     //TIPO ID
public interface ClenteRepository extends JpaRepository<Cliente, Integer> {

	
	
}
