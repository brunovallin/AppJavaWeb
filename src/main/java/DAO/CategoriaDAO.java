package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import VO.Categoria;

public class CategoriaDAO extends BaseDAO implements IDao {
	private Categoria vo;

	public Categoria getVo() {
		return vo;
	}
	public void setVo(Categoria vo) {
		this.vo = vo;
	}
	public CategoriaDAO() {
	}
	public CategoriaDAO(Categoria categoria) {
		this.vo = categoria;
	}

	public ArrayList<Categoria> getCategorias() throws Exception{
		abrir();
		ArrayList <Categoria> lst = new ArrayList<Categoria>();
		Statement s = getConn().createStatement(); 
		String sql = "SELECT id,nome,descricao FROM Categoria";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Categoria p= new Categoria();
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));	
			p.setDescricao(rs.getString(3));
			lst.add(p);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
	}
	public ArrayList<Categoria> findCategorias(String nome)  throws Exception{

		super.abrir();
		ArrayList <Categoria> lst = new ArrayList();
		String sql = "SELECT id,nome, descricao FROM Categoria where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, nome+'%');  
		ResultSet rs =   preparedStmt.executeQuery();
		while (rs.next()) { 
			Categoria p= new Categoria();
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));		
			p.setDescricao(rs.getString(3));
			lst.add(p);
		}
		preparedStmt.close();
		rs.close();
		fechar();
		return lst;
	}


	@Override
	public void save() {
		try {
			abrir();		
			String query = " insert into Categoria (nome,descricao)"
					+ " values (?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getDescricao());
			preparedStmt.execute();
			fechar();
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	}

	@Override
	public void load() {
		try {
			abrir();

			String sql = "SELECT id,nome,descricao FROM Categoria where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getId());  

			ResultSet rs =   preparedStmt.executeQuery();
			this.vo = new Categoria();
			while (rs.next()) { 
				this.vo.setId(Integer.parseInt(rs.getString(1)) );
				this.vo.setNome(rs.getString(2));		
				this.vo.setDescricao(rs.getString(3));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
		}
	}

	public boolean load(int id) {
		boolean retorno = false;
		try {
			abrir();

			String sql = "SELECT id,nome,descricao FROM Categoria where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, id);

			ResultSet rs =   preparedStmt.executeQuery();
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

			String query = " update Categoria set nome=?, descricao=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getDescricao());
			preparedStmt.setInt(3, this.vo.getId()); 
			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
		}
	}
	@Override
	public void delete() {

		try {
			abrir();
			String query = " delete from Categoria where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getId());    
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}		

	}
}
