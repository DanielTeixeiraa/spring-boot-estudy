package com.daniel.teste;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.teste.enums.EstadoPagamento;
import com.daniel.teste.enums.TipoCliente;
import com.daniel.teste.models.Categoria;
import com.daniel.teste.models.Cidade;
import com.daniel.teste.models.Cliente;
import com.daniel.teste.models.Endereco;
import com.daniel.teste.models.Estado;
import com.daniel.teste.models.ItemPedido;
import com.daniel.teste.models.Pagamento;
import com.daniel.teste.models.PagamentoBoleto;
import com.daniel.teste.models.PagamentoCartao;
import com.daniel.teste.models.Pedido;
import com.daniel.teste.models.Produto;
import com.daniel.teste.repositories.CategoriaRepository;
import com.daniel.teste.repositories.CidadeRepository;
import com.daniel.teste.repositories.ClienteRepository;
import com.daniel.teste.repositories.EnderecoRepository;
import com.daniel.teste.repositories.EstadoRepository;
import com.daniel.teste.repositories.ItemPedidoRepository;
import com.daniel.teste.repositories.PagamentoRepository;
import com.daniel.teste.repositories.PedidoRepository;
import com.daniel.teste.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner { //USADO PARA COLOCAR FUNÇOES NO MAIN

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estado es1 = new Estado(null, "minas");
		Estado es2 = new Estado(null, "Sp");

		Cidade c1 = new Cidade(null, "Uberlandia", es1);
		Cidade c2 = new Cidade(null, "sao paulo", es2);
		Cidade c3 = new Cidade(null, "campinas", es2);

		es1.getCidades().addAll(Arrays.asList(c2, c3));
		es2.getCidades().addAll(Arrays.asList(c1));

		estadoRepository.saveAll(Arrays.asList(es1, es2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "333222999", TipoCliente.PESSOA_FISICA);

		cli1.getNumero().addAll(Arrays.asList("22993909987"));

		Endereco e1 = new Endereco(null, "Rua ceara", "89", "Casa", "Centro", "201278", c1, cli1);
		Endereco e2 = new Endereco(null, "Rua sao paulo", "29", "Casa", "Centro", "202876", c2, cli1);

		cli1.getEndecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
//
//		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:39"), cli1, e1);
//		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 17:39"), cli1, e2);
//
//		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
//		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/10/2017 00:00"), null);
//		ped1.setPagamento(pag1);
//		ped2.setPagamento(pag2);
//		
//		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
//		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
//		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
//		
//		ItemPedido iten1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
//		ItemPedido iten2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
//		ItemPedido iten3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
//		
//		ped1.getItens().addAll(Arrays.asList(iten1,iten2));
//		ped2.getItens().addAll(Arrays.asList(iten3));
//		
//		p1.getItens().addAll(Arrays.asList(iten1));
//		p2.getItens().addAll(Arrays.asList(iten3));
//		p3.getItens().addAll(Arrays.asList(iten2));
//		
//		itemPedidoRepository.saveAll(Arrays.asList(iten1,iten2,iten3));
	}
}