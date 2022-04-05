package DAO;

import java.util.ArrayList;

import VO.Cliente;
import VO.Colaborador;
import VO.Pedido;
import VO.Produto;



public class PedidoDAO {
	public ArrayList<Pedido> getPedidos(){
		ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedidoOne = new Pedido();
		Cliente clienteOne = new Cliente();
		Produto produtoOne = new Produto();
		Colaborador colaboradorOne = new Colaborador();

		Pedido pedidoTwo = new Pedido();
		Cliente clienteTwo = new Cliente();
		Produto produtoTwo = new Produto();		
		Colaborador colaboradorTwo = new Colaborador();
		
		// MOCK ONE
		
		clienteOne.setAtivo(true);
		clienteOne.setBairro("Paineira");
		clienteOne.setCep("08581100");
		clienteOne.setCidade("Itaquaquecetuba");
		clienteOne.setCodigo(1);
		clienteOne.setCpf("123456789");
		clienteOne.setEmail("teste@gmail.com");
		clienteOne.setEndereco("Rua teste");
		clienteOne.setNome("Joao pedro");
		clienteOne.setTelefone("11948594758");
		
		produtoOne.setCodigo(1);
		produtoOne.setNome("Arroz");
		produtoOne.setDescricao("Produto 1");
		produtoOne.setEan(449784139);
		produtoOne.setCategoria("Categoria 3");
		produtoOne.setPreco(2.64);
		produtoOne.setAtivo(true);
		
		colaboradorOne.setCodigo(123124);
		colaboradorOne.setNome("João");
		colaboradorOne.setEmail("joao@eletiva.org.br");
		colaboradorOne.setCargo("Ajudante Geral");
		colaboradorOne.setObservacao("");
		colaboradorOne.setAtivo(true);
		
		pedidoOne.setCodigoPedido(1);   
		pedidoOne.setCliente(clienteOne);
		pedidoOne.setProduto(produtoOne);
		pedidoOne.setVendedor(colaboradorOne);
		pedidos.add(pedidoOne);
		
		
		// MOCK TWO
	
		clienteTwo.setAtivo(true);
		clienteTwo.setBairro("Paineira");
		clienteTwo.setCep("08581100");
		clienteTwo.setCidade("Itaquaquecetuba");
		clienteTwo.setCodigo(2);
		clienteTwo.setCpf("123456789");
		clienteTwo.setEmail("maria@gmail.com");
		clienteTwo.setEndereco("Rua teste");
		clienteTwo.setNome("Maria tste");
		clienteTwo.setTelefone("119485944558");
		
		produtoTwo.setCodigo(2);
		produtoTwo.setNome("Creme Dental");
		produtoTwo.setDescricao("Produto 2");
		produtoTwo.setEan(449784137);
		produtoTwo.setCategoria("Categoria 1");
		produtoTwo.setPreco(2.64);
		produtoTwo.setAtivo(true);
		
		colaboradorTwo.setCodigo(123124);
		colaboradorTwo.setNome("Maria");
		colaboradorTwo.setEmail("maria@eletiva.org.br");
		colaboradorTwo.setCargo("Custureira");
		colaboradorTwo.setObservacao("");
		colaboradorTwo.setAtivo(true);
		
        pedidoTwo.setCodigoPedido(2);
		pedidoTwo.setCliente(clienteTwo);
		pedidoTwo.setProduto(produtoTwo);
		pedidoTwo.setVendedor(colaboradorTwo);
		
		pedidos.add(pedidoTwo);
		
		return pedidos;
	}
}
