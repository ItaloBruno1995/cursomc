package com.udemy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	//Instaciar obejtos automaticamente ao iniciar 
	@Override
	public void run(String... args) throws Exception {
	Categoria cat1 = new Categoria(null, "Informatica");
	Categoria cat2 = new Categoria(null, "Escritorio");
	
	//Salvar no Banco de Dados
	repository.save(Arrays.asList(cat1,cat2));
	
		
	}
}
