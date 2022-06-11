package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Categoria;
import DAO.CategoriaDAO;
/**
 * Servlet implementation class ApagarCategoria
 */
public class ApagarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	    try {
	    	Categoria vo = new Categoria();	    
		    vo.setId(Integer.parseInt(request.getParameter("id")));	   
		    CategoriaDAO dao= new CategoriaDAO(vo);
			dao.delete();
			response.setContentType("text/html");
			out.println("Registro Excluido Sucesso");
			
			out.println("<a href='ListaCategoria'>Voltar</a>");
			out.close();
		} catch (Exception e) {
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
