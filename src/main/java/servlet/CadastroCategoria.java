package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;

/**
 * Servlet implementation class CadastroCategoria
 */
public class CadastroCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria vo = new Categoria();
		vo.setId(Integer.parseInt(request.getParameter("id") != null?request.getParameter("id"):"0"));
		vo.setNome(request.getParameter("nome"));
		vo.setDescricao(request.getParameter("descricao"));
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#do	Post(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Categoria vo = new Categoria();
		vo.setId(Integer.parseInt((request.getParameter("id") == null || request.getParameter("id").isBlank()) ?"0":request.getParameter("id")));
		vo.setNome( request.getParameter("nome"));
	    vo.setDescricao( request.getParameter("descricao"));
	    CategoriaDAO dao = new CategoriaDAO(vo);
		try {
			response.setContentType("text/html");
			if(vo.getId() > 0) {
				dao.edit();
				out.println("Registro alterado com sucesso!");
			}
			else{
				dao.save();
				out.println("Registro incluído com sucesso!");
			}

			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
		
	}

}
