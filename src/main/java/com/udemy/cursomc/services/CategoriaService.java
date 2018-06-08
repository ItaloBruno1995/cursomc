package com.udemy.cursomc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.repositories.CategoriaRepository;



@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository; //SERVIÇO ACESSO O REPOSITORY
	
	/**
	 * Metodo vai ao banco de dados 
	 * Busca uma categoria por Id 
	 * E retorna um objeto
	 * @param id
	 * @return
	 */
	public Categoria buscar(Integer id) {
		Categoria obj = repository.findOne(id);
		return obj;
	}
	
	
	
}
