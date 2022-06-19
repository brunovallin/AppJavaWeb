package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Categoria;
import VO.Cliente;

public class ClienteDAO extends BaseDAO implements IDao {
	private Cliente vo;
	
	public Cliente getVo() {
		return vo;
	}
	public void setVo(Cliente vo) {
		this.vo = vo;
	}
	public ClienteDAO() {
	}
	public ClienteDAO(Cliente cliente) {
		this.vo = cliente;
	}
	
	public ArrayList<Cliente> getClientes() throws Exception{
		abrir();
		ArrayList <Cliente> lst = new ArrayList<Cliente>();
		
		Statement s = getConn().createStatement(); 
		String sql = "select id, nome, email, telefone, endereco, bairro, cidade, cep, cpf, ativo from Cliente";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Cliente cliente = new Cliente();
			
			cliente.setCodigo(Integer.parseInt(rs.getString(1)));
			cliente.setNome(rs.getString(2));
			cliente.setEmail(rs.getString(3));
			cliente.setTelefone(rs.getString(4));
			cliente.setEndereco(rs.getString(5));
			cliente.setBairro(rs.getString(6));
			cliente.setCidade(rs.getString(7));
			cliente.setCep(rs.getString(8));
			cliente.setCpf(rs.getString(9));
			cliente.setAtivo(rs.getBoolean(10));
			
			lst.add(cliente);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
		
	}
	
	public ArrayList<Cliente> findCategorias(String nome)  throws Exception{

		super.abrir();
		ArrayList <Cliente> lst = new ArrayList<Cliente>();
		String sql = "select id, nome, email, telefone, endereco, bairro, cidade, cep, cpf, ativo from Cliente where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, "%".concat(nome).concat("%"));  
		ResultSet rs =   preparedStmt.executeQuery();
		while (rs.next()) { 
			Cliente cliente = new Cliente();
			
			cliente.setCodigo(Integer.parseInt(rs.getString(1)));
			cliente.setNome(rs.getString(2));
			cliente.setEmail(rs.getString(3));
			cliente.setTelefone(rs.getString(4));
			cliente.setEndereco(rs.getString(5));
			cliente.setBairro(rs.getString(6));
			cliente.setCidade(rs.getString(7));
			cliente.setCep(rs.getString(8));
			cliente.setCpf(rs.getString(9));
			cliente.setAtivo(rs.getBoolean(10));
			
			lst.add(cliente);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}
	
	public void save () {
		try {
			System.out.println("megnow started insert ");
			abrir();
			String query = " insert into Cliente (nome, email, telefone, endereco, bairro, cidade, cep, cpf)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getEmail());
			preparedStmt.setString (3, this.vo.getTelefone());
			preparedStmt.setString (4, this.vo.getEndereco());
			preparedStmt.setString (5, this.vo.getBairro());
			preparedStmt.setString (6, this.vo.getCidade());
			preparedStmt.setString (7, this.vo.getCep());
			preparedStmt.setString (8, this.vo.getCpf());
			preparedStmt.execute();
			fechar();
			System.out.println("megnow stoped insert ");
		} catch (SQLException e) {
			System.out.println("megnow" + e.getMessage());
		} catch (Exception e) {
		}
	}
	
	public void edit () {
		try {
			abrir();

			String query = " update Cliente set nome=?, email=?, telefone=?, endereco=?, bairro=?, cidade=?, cep=?, cpf=?, ativo=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getEmail());
			preparedStmt.setString (3, this.vo.getTelefone());
			preparedStmt.setString (4, this.vo.getEndereco());
			preparedStmt.setString (5, this.vo.getBairro());
			preparedStmt.setString (6, this.vo.getCidade());
			preparedStmt.setString (7, this.vo.getCep());
			preparedStmt.setString (8, this.vo.getCpf());
			preparedStmt.setBoolean(9, this.vo.isAtivo());
			preparedStmt.setInt(10, this.vo.getCodigo());

			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
		}
	}
	
	public void load () {
		try {
			abrir();

			String sql = "select id, nome, email, telefone, endereco, bairro, cidade, cep, cpf, ativo from Cliente where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getCodigo());  

			ResultSet rs =   preparedStmt.executeQuery();
			this.vo = new Cliente();
			while (rs.next()) { 
				this.vo.setCodigo(Integer.parseInt(rs.getString(1)));
				this.vo.setNome(rs.getString(2));
				this.vo.setEmail(rs.getString(3));
				this.vo.setTelefone(rs.getString(4));
				this.vo.setEndereco(rs.getString(5));
				this.vo.setBairro(rs.getString(6));
				this.vo.setCidade(rs.getString(7));
				this.vo.setCep(rs.getString(8));
				this.vo.setCpf(rs.getString(9));
				this.vo.setAtivo(rs.getBoolean(10));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
		}
	}
	
	public ArrayList<Cliente> findClientes(String nome) {
		ArrayList<Cliente> c = new ArrayList<Cliente>();
		
		return c;
	}
	
	public void delete () {
		try {
			abrir();
			String query = " delete from Cliente where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCodigo());    
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}
	}
}
