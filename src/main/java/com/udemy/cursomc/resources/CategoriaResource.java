package com.udemy.cursomc.resources;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired // CONTROLADOR ACESSANDO O SERVICO
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);// O CORPO DA RESPOSTA É O OBJETO

	}

	// RECEBER CATEGORIA E INSERIR NO BANCO DE DADOS(Void: retornar somente uma
	// mesagem)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		//O METODO VAI TER QUE CHAMAR UM SERVIÇO QUE FAÇA A INSERÇÃO
		obj= service.insert(obj);//SAVE: RETORNA UM OBJETO
		//PEGA O NOVO ID E FORNER NA URI (PRGA A URL E ACRESENTA) (CRIA A URI DO NOVO RECURSO)
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
	return ResponseEntity.created(uri).build(); //RETORNA A URI DO OBJETO CRIADO
	}

}
