package DAO;

import java.util.ArrayList;

import VO.Colaborador;

public class ColaboradorDAO {
	public ArrayList<Colaborador> getColaboradores(){
		ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
		Colaborador colaboradorOne = new Colaborador();
		Colaborador colaboradorTwo = new Colaborador();
		
		colaboradorOne.setCodigo(123124);
		colaboradorOne.setNome("João");
		colaboradorOne.setEmail("joao@eletiva.org.br");
		colaboradorOne.setCargo("Ajudante Geral");
		colaboradorOne.setObservacao("");
		colaboradorOne.setAtivo(true);
		colaboradores.add(colaboradorOne);

		colaboradorTwo.setCodigo(123124);
		colaboradorTwo.setNome("Maria");
		colaboradorTwo.setEmail("maria@eletiva.org.br");
		colaboradorTwo.setCargo("Custureira");
		colaboradorTwo.setObservacao("");
		colaboradorTwo.setAtivo(true);
		colaboradores.add(colaboradorTwo);
	
		return colaboradores;
	}	
}
