package DAO;

import java.util.ArrayList;

import VO.Colaborador;

public class ColaboradorDAO {
	public ArrayList<Colaborador> getColaboradores(){
		ArrayList<Colaborador> c = new ArrayList<Colaborador>();
		Colaborador colab = new Colaborador();
		colab.setCodigo(123124);
		colab.setNome("João");
		colab.setEmail("joao@eletiva.org.br");
		colab.setCargo("Ajudante Geral");
		colab.setObservacao("");
		colab.setAtivo(true);
		c.add(colab);
		
		return c;
	}	
}
