package VO;

public class Pedido {
	private int codigoPedido;
	
	private Integer cliente;
	
	private Integer vendedor;
	
	private Integer produto;
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public Integer getVendedor() {
		return vendedor;
	}
	public void setVendedor(Integer vendedor) {
		this.vendedor = vendedor;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
}
