package com.daniel.teste.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.teste.enums.EstadoPagamento;
import com.daniel.teste.enums.TipoCliente;
import com.daniel.teste.models.Categoria;
import com.daniel.teste.models.Cidade;
import com.daniel.teste.models.Cliente;
import com.daniel.teste.models.Endereco;
import com.daniel.teste.models.Estado;
import com.daniel.teste.models.ItemPedido;
import com.daniel.teste.models.Pagamento;
import com.daniel.teste.models.PagamentoComBoleto;
import com.daniel.teste.models.PagamentoComCartao;
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
@Service
public class DBservice {
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
	public  void iniciar() throws ParseException {
		
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
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));	

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "333222999", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("22993909987"));

		Endereco e1 = new Endereco(null, "Rua ceara", "89", "Casa", "Centro", "201278", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua sao paulo", "29", "Casa", "Centro", "202876", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:39"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 17:39"), cli1, e2);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/10/2017 00:00"), null);
		ped1.setPagamento(pag1);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
		
		ItemPedido iten1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido iten2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido iten3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(iten1,iten2));
		ped2.getItens().addAll(Arrays.asList(iten3));
		
		p1.getItens().addAll(Arrays.asList(iten1));
		p2.getItens().addAll(Arrays.asList(iten3));
		p3.getItens().addAll(Arrays.asList(iten2));
		
		itemPedidoRepository.saveAll(Arrays.asList(iten1,iten2,iten3));
	}
}
