package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import DAO.ColaboradorDAO;
import VO.Categoria;
import VO.Colaborador;

/**
 * Servlet implementation class CadastroColaborador
 */
public class CadastroColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroColaborador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Colaborador vo = new Colaborador();
		vo.setCodigo(Integer.parseInt(request.getParameter("codigo") != null?request.getParameter("codigo"):"0"));
		vo.setNome(request.getParameter("nome"));
		vo.setCargo(request.getParameter("cargo"));
		vo.setEmail(request.getParameter("email"));
		vo.setObservacao(request.getParameter("observacao"));
		vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Colaborador vo = new Colaborador();
		vo.setCodigo(Integer.parseInt((request.getParameter("codigo") == null || request.getParameter("codigo").isBlank()) ?"0":request.getParameter("codigo")));
		vo.setNome( request.getParameter("nome"));
	    vo.setCargo( request.getParameter("cargo"));
	    vo.setEmail( request.getParameter("email"));
	    vo.setObservacao( request.getParameter("observacao"));
	    vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
	    ColaboradorDAO dao = new ColaboradorDAO(vo);
		try {
			response.setContentType("text/html");
			if(vo.getCodigo() > 0) {
				dao.edit();
				out.println("Registro alterado com sucesso!");
				out.println("<a href='ListaColaborador'>Voltar</a>");
			}
			else{
				dao.save();
				out.println("Registro incluído com sucesso!");
				out.println("<a href='ListaColaborador'>Voltar</a>");
			}

			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}

}
