package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Categoria;

/**
 * Servlet implementation class LIstaCategoria
 */
public class ListaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
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
		
		request.setAttribute("listaCat", lstCat);		
		request.getRequestDispatcher("/ListaCategoria.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
