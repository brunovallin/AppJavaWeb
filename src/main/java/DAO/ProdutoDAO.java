package DAO;
import java.util.ArrayList;

import VO.Produto;
public class ProdutoDAO {
	public ArrayList<Produto> getProdutos(){
		ArrayList <Produto> lst = new ArrayList<Produto>();
		Produto p= new Produto();
		p.setCodigo(1);
		p.setNome("Arroz");
		p.setDescricao("Produto 1");
		p.setEan(449784139);
		p.setCategoria("Categoria 3");
		p.setPreco(2.64);
		p.setAtivo(true);;
		lst.add(p);
		
		p.setCodigo(2);
		p.setNome("Creme Dental");
		p.setDescricao("Produto 2");
		p.setEan(449784137);
		p.setCategoria("Categoria 1");
		p.setPreco(2.64);
		p.setAtivo(true);
		lst.add(p);
		
		p.setCodigo(3);
		p.setNome("Maçã");
		p.setDescricao("Produto 3");
		p.setEan(449784137);
		p.setCategoria("Categoria 2");
		p.setPreco(2.64);
		p.setAtivo(true);
		lst.add(p);
		
		System.out.println (lst);
		return lst;
	}
}
