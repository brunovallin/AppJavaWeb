package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Pedido;

public class PedidoDAO extends BaseDAO implements IDao {
	
	private Pedido vo;

	public Pedido getVo() {
		return vo;
	}
	public void setVo(Pedido vo) {
		this.vo = vo;
	}
	
	public PedidoDAO() {
	}
	
	public PedidoDAO(Pedido pedido) {
		this.vo = pedido;
	}
	
	public ArrayList<Pedido> getPedidos() throws Exception{
		abrir();
		ArrayList <Pedido> lst = new ArrayList<Pedido>();
		Statement s = getConn().createStatement(); 
		String sql = "select id, clienteId, vendedorId, produtoId from Pedido";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Pedido pedido = new Pedido();
			pedido.setCodigoPedido(rs.getInt(1));
			pedido.setCliente(rs.getInt(2));
			pedido.setVendedor(rs.getInt(3));
			pedido.setProduto(rs.getInt(4));
			lst.add(pedido);
		}
		s.close();
		rs.close();
		
		
		fechar();
		return lst;
	}
	
	public ArrayList<Pedido> findPedidos(String id)  throws Exception{
		super.abrir();
		
		ArrayList <Pedido> lst = new ArrayList<Pedido>();
		String sql = "SELECT id,nome, observacao FROM Pedido where id like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString(1, "%".concat(id).concat("%"));
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) { 
			Pedido pedido = new Pedido();
			pedido.setCodigoPedido(rs.getInt(1));
			pedido.setCliente(rs.getInt(2));
			pedido.setVendedor(rs.getInt(3));
			pedido.setProduto(rs.getInt(4));
			lst.add(pedido);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}


	@Override
	public void save() {
		try {
			System.out.println("megnow started insert ");
			abrir();
			String query = " insert into Pedido (clienteId, vendedorId, produtoId)"
					+ " values (?, ?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCliente());
			preparedStmt.setInt(2, this.vo.getVendedor());
			preparedStmt.setInt(3, this.vo.getProduto());
			preparedStmt.execute();
			fechar();
			System.out.println("megnow stoped insert ");
		} catch (SQLException e) {
			System.out.println("megnow" + e.getMessage());
		} catch (Exception e) {
		}
	}

	@Override
	public void load() {
		try {
			abrir();

			String sql = "select id, clienteId, vendedorId, produtoId from Pedido where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getCodigoPedido());
			System.out.println("[LOAD] get pedido with id " + this.vo.getCodigoPedido());

			ResultSet rs = preparedStmt.executeQuery();
			this.vo = new Pedido();
			while (rs.next()) {
				this.vo.setCodigoPedido(Integer.parseInt(rs.getString(1)));
				this.vo.setCliente(Integer.parseInt(rs.getString(2)));
				this.vo.setVendedor(Integer.parseInt(rs.getString(3)));		
				this.vo.setProduto(Integer.parseInt(rs.getString(4)));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
			System.out.println("[LOAD] ERROR - get pedido with id " + e);
		}
	}

	public boolean load(int id) {
		boolean retorno = false;
		try {
			abrir();

			String sql = "select id, clienteId, vendedorId, produtoId from Pedido where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, id);

			ResultSet rs = preparedStmt.executeQuery();
			rs.last();
			if(rs.getInt(1) > 0)
				retorno = true;
			rs.close();
			fechar();
		} catch(Exception e) {
		}
		return retorno;	
	}

	@Override
	public void edit(){
		try {
			abrir();

			String query = " update Pedido set clienteId=?, vendedorId=?, produtoId=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt (1, this.vo.getCliente());
			preparedStmt.setInt (2, this.vo.getVendedor());
			preparedStmt.setInt(3, this.vo.getProduto());
			preparedStmt.setInt(4, this.vo.getCodigoPedido()); 
			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
		}
	}
	@Override
	public void delete() {

		try {
			abrir();
			String query = " delete from Pedido where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCodigoPedido());
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}		

	}

}

