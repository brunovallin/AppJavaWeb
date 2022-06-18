package DAO;
import java.util.ArrayList;

import VO.Produto;
public class ProdutoDAO {
	public ArrayList<Produto> getProdutos(){
			
		ArrayList <Produto> lst = new ArrayList();
		Produto p= new Produto();
		p.setCodigo(0);
		p.setNome("Teste 1");
		
		lst.add(p);
		Produto p2= new Produto();
		p2.setCodigo(1);
		p2.setNome("Teste 2");

		lst.add(p2);
		Produto p3= new Produto();
		p3.setCodigo(2);
		p3.setNome("Teste 3");

		lst.add(p3);
		Produto p4= new Produto();
		p4.setCodigo(3);
		p4.setNome("Teste Prod 4");

		lst.add(p4);
		return lst;
	}
	public ArrayList<Produto> findProdutos(String nome){
		
		ArrayList <Produto> lst = new ArrayList();
		Produto p= new Produto();
		p.setCodigo(0);
		p.setNome("Teste 1");
		
		lst.add(p);		
		return lst;
	}
	public void newProduto(Produto p){
		
		
	}
	public void editProduto(Produto p){
		
		
	}
	public void deleteProduto(Produto p){
		
		
	}
	public Produto findByIdProduto(int id){
		Produto p = new Produto();
		p.setCodigo(2);
		p.setNome("Teste 3");
		return p;
	}
}
