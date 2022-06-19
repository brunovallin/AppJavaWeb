package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;

/**
 * Servlet implementation class ListaCliente
 */
public class ListaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nome;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDAO dao = new ClienteDAO();

		PrintWriter out = response.getWriter();
		nome = request.getParameter("nome");
		try {
		if( nome == null || nome.isEmpty()) {
			request.setAttribute("listaClientes", dao.getClientes());
		}
		else {
			request.setAttribute("listaClientes", dao.findClientes(nome));
		}
		request.getRequestDispatcher("/ListaCliente.jsp").forward(request, response);
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
