package DAO;

import java.util.ArrayList;
import VO.Categoria;

public class CategoriaDAO {
	public ArrayList<Categoria> getCategoria()
	{
		ArrayList<Categoria> lstCat = new ArrayList<Categoria>();
		Categoria c = new Categoria();
		c.setCodigo(1);
		c.setNome("Higiene");
		c.setDescricao("Higiene Pessoal");
		lstCat.add(c);
		c = new Categoria();
		c.setCodigo(2);
		c.setNome("HortiFruti");
		c.setDescricao("Hortifruti em geral");
		lstCat.add(c);
		c = new Categoria();
		c.setCodigo(3);
		c.setNome("Açougue");
		c.setDescricao("Carnes em geral");
		lstCat.add(c);
		
		return lstCat;
	}
}
