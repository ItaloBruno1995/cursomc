package com.udemy.cursomc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Pedido;
import com.udemy.cursomc.repositories.PedidoRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository; //SERVIÇO ACESSO O REPOSITORY
	
	/**
	 * Metodo vai ao banco de dados 
	 * Busca uma categoria por Id 
	 * E retorna um objeto
	 * @param id
	 * @return
	 */
	public Pedido buscar(Integer id) {
		Pedido obj = repository.findOne(id);
		if(obj == null) {//Não encontrou o Objeto retornar uma exption
			throw new ObjectNotFoundException("Objeto não encontrado para id: "+id+" tipo: "+Pedido.class.getName());//Lançar exp
		}
		return obj;
	}
	
	
	
}
