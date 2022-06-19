package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Produto;
public class ProdutoDAO extends BaseDAO implements IDao {

	private Produto vo;

	public Produto getVo() {
		return vo;
	}
	public void setVo(Produto vo) {
		this.vo = vo;
	}
	
	public ProdutoDAO() {
	}
	
	public ProdutoDAO(Produto produto) {
		this.vo = produto;
	}
	
	public ArrayList<Produto> getProdutos() throws Exception{
		abrir();
		ArrayList <Produto> lst = new ArrayList<Produto>();
		Statement s = getConn().createStatement(); 
		String sql = "select id, nome, descricao, ean, categoria, preco, ativo from Produto";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Produto produto = new Produto();
			produto.setCodigo(rs.getInt(1));
			produto.setNome(rs.getString(2));
			produto.setDescricao(rs.getString(3));
			produto.setEan(Long.parseLong(rs.getString(4)));
			produto.setCategoria(rs.getString(5));
			produto.setPreco(Double.parseDouble(rs.getString(6)));
			produto.setAtivo(rs.getBoolean(7));
			lst.add(produto);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
	}
	
	public ArrayList<Produto> findProdutos(String nome)  throws Exception{
		super.abrir();
		
		ArrayList <Produto> lst = new ArrayList<Produto>();
		String sql = "select id, nome, descricao, ean, categoria, preco, ativo from Produto where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, "%".concat(nome).concat("%"));  
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) { 
			Produto produto = new Produto();
			produto.setCodigo(rs.getInt(1));
			produto.setNome(rs.getString(2));
			produto.setDescricao(rs.getString(3));
			produto.setEan(Long.parseLong(rs.getString(4)));
			produto.setCategoria(rs.getString(5));
			produto.setPreco(Double.parseDouble(rs.getString(6)));
			produto.setAtivo(Boolean.parseBoolean(rs.getString(7)));
			lst.add(produto);
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
			String query = "insert into Produto(nome, descricao, ean, categoria, preco)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString(1, this.vo.getNome());
			preparedStmt.setString(2, this.vo.getDescricao());
			preparedStmt.setLong(3, this.vo.getEan());
			preparedStmt.setString(4, this.vo.getCategoria());
			preparedStmt.setDouble(5, this.vo.getPreco());
			preparedStmt.execute();
			fechar();
			System.out.println("megnow stoped insert ");
		} catch (SQLException e) {
			System.out.println("megnow" + e.getMessage());
		} catch (Exception e) {
			System.out.println("megnow EXCEPTION" + e.getMessage());
		}
	}


	@Override
	public void load() {
		try {
			abrir();

			String sql = "select id, nome, descricao, ean, categoria, preco, ativo from Produto where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getCodigo());
			System.out.println("[LOAD] get cargo with id " + this.vo.getCodigo());

			ResultSet rs = preparedStmt.executeQuery();
			this.vo = new Produto();
			while (rs.next()) { 
				this.vo.setCodigo(Integer.parseInt(rs.getString(1)) );
				this.vo.setNome(rs.getString(2));		
				this.vo.setDescricao(rs.getString(3));
				this.vo.setEan(rs.getLong(4));		
				this.vo.setCategoria(rs.getString(5));
				this.vo.setPreco(rs.getDouble(6));		
				this.vo.setAtivo(rs.getBoolean(7));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
			System.out.println("[LOAD] ERROR - get Produto" + e);
		}
	}

	public boolean load(int id) {
		boolean retorno = false;
		try {
			abrir();

			String sql = "select id, nome, descricao, ean, categoria, preco, ativo from Produto where id=?";

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

			String query = " update Produto set nome=?, descricao=?, ean=?, categoria=?, preco=?, ativo=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString(1, this.vo.getNome());
			preparedStmt.setString(2, this.vo.getDescricao());
			preparedStmt.setLong (3, this.vo.getEan());
			preparedStmt.setString(4, this.vo.getCategoria());
			preparedStmt.setDouble(5, this.vo.getPreco());
			preparedStmt.setBoolean(6, this.vo.isAtivo());
			preparedStmt.setInt(7, this.vo.getCodigo()); 
			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
			System.out.println("[LOAD] ERROR - edit Produto" + e.getMessage());
		}
	}
	@Override
	public void delete() {

		try {
			abrir();
			String query = " delete from Produto where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCodigo());    
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}		

	}

}
