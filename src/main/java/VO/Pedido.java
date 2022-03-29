package VO;

public class Pedido {
	private int codigoPedido;
	
	private Cliente cliente;
	
	private Colaborador vendedor;
	
	private Produto produto;
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Colaborador getVendedor() {
		return vendedor;
	}
	public void setVendedor(Colaborador vendedor) {
		this.vendedor = vendedor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
