package com.udemy.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.repositories.ClenteRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	
	@Autowired
	private ClenteRepository clienteRepository;
	
	
	
	//BUSCAR(Cliente )
	
	public Cliente buscar(Integer id) {
		Cliente obj= clienteRepository.findOne(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado para id: "+id+" tipo: "+Cliente.class.getName());
		}
		return obj;
	}
	
	
}
