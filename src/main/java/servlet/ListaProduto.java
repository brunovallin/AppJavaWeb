package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import DAO.ProdutoDAO;
import VO.*;

/**
 * Servlet implementation class ListaCadastro
 */
public class ListaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nome;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO dao = new ProdutoDAO();
		PrintWriter out = response.getWriter();
		nome = request.getParameter("nome");
		
		try {
			if ( nome == null || nome.isEmpty()) {
				request.setAttribute("listaProduto", dao.getProdutos());
			} else {
				request.setAttribute("listaProduto", dao.findProdutos(nome));	
			}
			request.getRequestDispatcher("/ListaPedido.jsp").forward(request, response);
		}catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
