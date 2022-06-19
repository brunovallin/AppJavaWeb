package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Colaborador;

public class ColaboradorDAO extends BaseDAO implements IDao {
	private Colaborador vo;

	public Colaborador getVo() {
		return vo;
	}
	public void setVo(Colaborador vo) {
		this.vo = vo;
	}
	
	public ColaboradorDAO() {
	}
	
	public ColaboradorDAO(Colaborador colaborador) {
		this.vo = colaborador;
	}
	
	public ArrayList<Colaborador> getColaboradores() throws Exception{
		abrir();
		ArrayList <Colaborador> lst = new ArrayList<Colaborador>();
		Statement s = getConn().createStatement(); 
		String sql = "select id, nome, cargo, email, observacao, ativo from Colaborador";
		ResultSet rs = s.executeQuery(sql);
		
		while (rs.next()) { 
			Colaborador colaborador = new Colaborador();
			colaborador.setCodigo(rs.getInt(1));
			colaborador.setNome(rs.getString(2));
			colaborador.setCargo(rs.getString(3));
			colaborador.setEmail(rs.getString(4));
			colaborador.setObservacao(rs.getString(5));
			colaborador.setAtivo(rs.getBoolean(6));
			lst.add(colaborador);
		}
		s.close();
		rs.close();		
		fechar();
		
		System.out.println("megnow started insert" + lst);
		return lst;
	}
	
	public ArrayList<Colaborador> findColaboradores(String nome)  throws Exception{
		super.abrir();
		
		ArrayList <Colaborador> lst = new ArrayList<Colaborador>();
		String sql = "select id, nome, cargo, email, observacao, ativo from Colaborador where nome like ?";
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setString (1, "%".concat(nome).concat("%"));  
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) { 
			Colaborador colaborador = new Colaborador();
			colaborador.setCodigo(rs.getInt(1));
			colaborador.setNome(rs.getString(2));
			colaborador.setCargo(rs.getString(3));
			colaborador.setEmail(rs.getString(4));
			colaborador.setObservacao(rs.getString(5));
			colaborador.setAtivo(rs.getBoolean(6));
			lst.add(colaborador);
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
			String query = " insert into Colaborador (nome, cargo, email, observacao)"
					+ " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getCargo());
			preparedStmt.setString (3, this.vo.getEmail());
			preparedStmt.setString (4, this.vo.getObservacao());
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

			String sql = "select id, nome, cargo, email, observacao, ativo from Colaborador where id=?";

			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, this.vo.getCodigo());
			
			System.out.println("[LOAD] get Colaborador with id " + this.vo.getCodigo());

			ResultSet rs = preparedStmt.executeQuery();
			this.vo = new Colaborador();
			while (rs.next()) { 
				this.vo.setCodigo(Integer.parseInt(rs.getString(1)) );
				this.vo.setNome(rs.getString(2));		
				this.vo.setCargo(rs.getString(3));
				this.vo.setEmail(rs.getString(4));
				this.vo.setObservacao(rs.getString(5));
				this.vo.setAtivo(rs.getBoolean(6));
			}
			rs.close();
			fechar();
		} catch(Exception e) {
			System.out.println("[LOAD] ERROR - get Colaborador" + e);
		}
	}

	public boolean load(int id) {
		boolean retorno = false;
		try {
			abrir();

			String sql = "select id, nome, cargo, email, observacao, ativo from Colaborador where id=?";

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

			String query = " update Colaborador set nome=?, cargo=?, email=?, observacao=?, ativo=? where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setString (1, this.vo.getNome());
			preparedStmt.setString (2, this.vo.getCargo());
			preparedStmt.setString (3, this.vo.getEmail());
			preparedStmt.setString (4, this.vo.getObservacao());
			preparedStmt.setBoolean(5, this.vo.isAtivo());
			preparedStmt.setInt(6, this.vo.getCodigo()); 
			preparedStmt.execute();
			fechar();
		} catch (Exception e) {
		}
	}
	@Override
	public void delete() {

		try {
			abrir();
			String query = " delete from Colaborador where id=?";
			PreparedStatement preparedStmt = getConn().prepareStatement(query);
			preparedStmt.setInt(1, this.vo.getCodigo());
			preparedStmt.execute();
			preparedStmt.close();
			fechar();
		} catch (Exception e) {
		}		

	}
}
