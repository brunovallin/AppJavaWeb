package DAO;

import java.util.ArrayList;

import VO.Cliente;

public class ClienteDAO {
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente clienteOne = new Cliente();
		Cliente clienteTwo = new Cliente();
		
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
		clientes.add(clienteOne);
		
		
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
		clientes.add(clienteTwo);
		
		
		return clientes;
	}
}
