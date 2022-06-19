package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.ColaboradorDAO;

import VO.Colaborador;

/**
 * Servlet implementation class ApagarColaborador
 */
public class ApagarColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarColaborador() {
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
	    	Colaborador vo = new Colaborador();	    
		    vo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		    ColaboradorDAO dao= new ColaboradorDAO(vo);
			dao.delete();
			response.setContentType("text/html");
			out.println("Registro Excluido Sucesso");
			
			out.println("<a href='ListaColaborador'>Voltar</a>");
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
