package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.ColaboradorDAO;

/**
 * Servlet implementation class ListaColaborador
 */
public class ListaColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nome;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaColaborador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ColaboradorDAO dao = new ColaboradorDAO();

		PrintWriter out = response.getWriter();
		nome = request.getParameter("nome");
		try {
		if( nome == null || nome.isEmpty()) {
			request.setAttribute("listaColaborador", dao.getColaboradores());
		}
		else {
			request.setAttribute("listaColaborador", dao.findColaboradores(nome));
		}
		request.getRequestDispatcher("/ListaColaborador.jsp").forward(request, response);
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
