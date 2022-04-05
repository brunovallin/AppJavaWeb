package DAO;

import java.util.ArrayList;
import VO.Categoria;

public class CategoriaDAO {
	public ArrayList<Categoria> getCategorias()
	{
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Categoria categoriaOne = new Categoria();
		
		categoriaOne.setCodigo(1);
		categoriaOne.setNome("Higiene");
		categoriaOne.setDescricao("Higiene Pessoal");
		
		categorias.add(categoriaOne);
		
		Categoria categoriaTwo = new Categoria();
		
		categoriaTwo.setCodigo(2);
		categoriaTwo.setNome("HortiFruti");
		categoriaTwo.setDescricao("Hortifruti em geral");
		categorias.add(categoriaTwo);
		
		Categoria categoriaThree = new Categoria();
		
		categoriaThree.setCodigo(3);
		categoriaThree.setNome("Açougue");
		categoriaThree.setDescricao("Carnes em geral");
		
		categorias.add(categoriaThree);
		
		return categorias;
	}
}
