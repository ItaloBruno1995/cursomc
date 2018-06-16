package com.udemy.cursomc;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.domain.Endereco;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.Pagamento;
import com.udemy.cursomc.domain.PagamentoComBoleto;
import com.udemy.cursomc.domain.PagamentoComCartao;
import com.udemy.cursomc.domain.Pedido;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.domain.enums.EstadoPagamento;
import com.udemy.cursomc.domain.enums.TipoCliente;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.ClenteRepository;
import com.udemy.cursomc.repositories.EnderecoRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.PagamentoRepository;
import com.udemy.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private ClenteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoReposutory;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		
		//CLIENTE/ ENDERCO / CIDADE
		 Cliente cli1 =  new Cliente(null, "Maria", "maria@gmail.com", "384637853785", TipoCliente.PESSOAFISICA);
		 
		 //CLIENTE TELEFONE
		 cli1.getTelefones().addAll(Arrays.asList("65836583","627587438"));
		 
		 //Endereco
		 Endereco e1= new Endereco(null, "Rua flores", "2", "apt 34", "Alegria", "7827-397", cli1, c1);
		 Endereco e2= new Endereco(null, "Rua da paz", "3", "apt 36", "Sabedoria", "7827-397", cli1, c2);
		 
		//Cliente  com endereco
		 cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		 
		 clienteRepository.save(cli1);
		 
		 enderecoReposutory.save(Arrays.asList(e1,e2));
		
		 

	
		 ///PAGAMNETO PEDIDO
		 //Instanciando data
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		 //Pedido
		 Pedido ped1= new Pedido(null, sdf.parse("20/10/2018 09:56"),cli1, e1);
		 
		 Pedido ped2= new Pedido(null, sdf.parse("20/10/2018 09:56"),cli1, e2);
		 
	
		 
		 //pagamento
		 
		 Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		 ped1.setPagamento(pag1);//Fazer o pagamento
		 
		 Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDETE, ped2, sdf.parse("20/10/2018 09:56"), null);
		 ped2.setPagamento(pag2);
		 
		 //Cliente com pedido
		 cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		 
		 
		 pedidoRepository.save(Arrays.asList(ped1,ped2));
		 pagamentoRepository.save(Arrays.asList(pag1,pag2));
		 
		 
	}
}
