package com.udemy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProdutoRepository repositoyproduto;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private  CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	//Instaciar obejtos automaticamente ao iniciar (testar)
	@Override
	public void run(String... args) throws Exception {
	Categoria cat1 = new Categoria(null, "Informatica");
	Categoria cat2 = new Categoria(null, "Escritorio");
	
	Produto p1 = new Produto(null, "Computador", 2000.00);
	
	Produto p2 = new Produto(null, "Impressora", 800.00);
	
	Produto p3 = new Produto(null, "Mouse", 80.000);
	
	//ASSOCIAR CARETOGIA AO PRODUTO:
	cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	cat2.getProdutos().addAll(Arrays.asList(p2));
	
	//ASSOCIAR PRODUTO COM SUA CATEGORIA
	p1.getCategorias().addAll(Arrays.asList(cat1));
	p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	p3.getCategorias().addAll(Arrays.asList(cat1));
	
	
	
	//SALVAR NO BANCO DE DADOS
	repository.save(Arrays.asList(cat1,cat2));
	repositoyproduto.save(Arrays.asList(p1,p2,p3));
		
	
	//INSTANCIA CIDADE ESTADO
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		
		//CIDADE COM ESTADO
		Cidade c1= new Cidade(null, "Urberlandia", est1);
		Cidade c2= new Cidade(null, "São Paulo ", est2);
		Cidade c3= new Cidade(null, "Campinas ", est2);
		
		
		//ESTADO COM CIDADE
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		
	
	}
}
