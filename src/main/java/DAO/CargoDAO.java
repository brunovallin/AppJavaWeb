package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Categoria;

public class CargoDAO extends BaseDAO implements IDao {
	
	private Cargo vo;

	public Cargo getVo() {
		return vo;
	}
	public void setVo(Cargo vo) {
		this.vo = vo;
	}
	
	public CargoDAO() {
	}
	
	public CargoDAO(Cargo cargo) {
		this.vo = cargo;
	}
	
	public ArrayList<Cargo> getCargos() throws Exception{
		abrir();
		ArrayList <Cargo> lst = new ArrayList<Cargo>();
		Statement s = getConn().createStatement(); 
		String sql = "SELECT id,nome,observacao FROM Cargo";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) { 
			Cargo cargo = new Cargo();
			cargo.setCodigo(rs.getInt(1));
			cargo.setNome(rs.getString(2));	
			cargo.setObservacao(rs.getString(3));
			lst.add(cargo);
		}
		s.close();
		rs.close();		
		fechar();
		return lst;
	}
	
	public ArrayList<Cargo> findCargos(String nome)  throws Exception{
		super.abrir();
		
		ArrayList <Cargo> lst = new ArrayList();
		String sql = "SELECT id,nome, observacao FROM Cargo where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, "%".concat(nome).concat("%"));  
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) { 
			Cargo cargo = new Cargo();
			cargo.setCodigo(rs.getInt(1));
			cargo.setNome(rs.getString(2));		
			cargo.setObservacao(rs.getString(3));
			lst.add(cargo);
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
			String query = " insert into Cargo (nome,observacao)"
					+ " values (?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getObservacao());
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

			String sql = "SELECT id,nome,observacao FROM Cargo where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getCodigo());
			System.out.println("[LOAD] get cargo with id " + this.vo.getCodigo());

			ResultSet rs = preparedStmt.executeQuery();
			this.vo = new Cargo();
			while (rs.next()) { 
				this.vo.setCodigo(Integer.parseInt(rs.getString(1)) );
				this.vo.setNome(rs.getString(2));		
				this.vo.setObservacao(rs.getString(3));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
			System.out.println("[LOAD] ERROR - get cargo with id " + e);
		}
	}

	public boolean load(int id) {
		boolean retorno = false;
		try {
			abrir();

			String sql = "SELECT id,nome,observacao FROM Cargo where id=?";

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

			String query = " update Cargo set nome=?, observacao=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getObservacao());
			preparedStmt.setInt(3, this.vo.getCodigo()); 
			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
		}
	}
	@Override
	public void delete() {

		try {
			abrir();
			String query = " delete from Cargo where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCodigo());    
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}		

	}

}
