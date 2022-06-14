package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;

/**
 * Servlet implementation class ListaCategoria
 */
public class ListaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nome;
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
		CategoriaDAO dao = new CategoriaDAO();
		PrintWriter out = response.getWriter();
		nome = request.getParameter("nome");
		try {
		if( nome == null || nome.isEmpty()) {
			request.setAttribute("listaCat", dao.getCategorias());
		}
		else {
			request.setAttribute("listaCat", dao.findCategorias(nome));	
		}
		request.getRequestDispatcher("/ListaCategoria.jsp").forward(request, response);
		}catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
