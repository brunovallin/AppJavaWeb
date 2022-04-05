package DAO;

import java.util.ArrayList;

import VO.Cargo;

public class CargoDAO {

	public ArrayList<Cargo> getCargos() {
		// TODO Auto-generated method stub
		
		ArrayList <Cargo> cargos = new ArrayList<Cargo>();
		Cargo cargoOne = new Cargo();
		Cargo cargoTwo = new Cargo();
		
		cargoOne.setCodigo(1);
		cargoOne.setNome("Desenvolvedor Jr");
		cargoOne.setObservacao("Recem efetivado de estagio");
		cargoOne.setAtivo(true);
		cargos.add(cargoOne);
		
		cargoTwo.setCodigo(2);
		cargoTwo.setNome("Desenvolvedor Pleno");
		cargoTwo.setObservacao("Recem promovido de junior");
		cargoTwo.setAtivo(true);
		
		cargos.add(cargoTwo);
		
		return cargos;
	}

}
