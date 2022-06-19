package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import VO.Cargo;
import VO.Categoria;

/**
 * Servlet implementation class CadastroCargo
 */
public class CadastroCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroCargo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cargo vo = new Cargo();
		vo.setCodigo(Integer.parseInt(request.getParameter("id") != null?request.getParameter("id"):"0"));
		vo.setNome(request.getParameter("nome"));
		vo.setObservacao(request.getParameter("observacao"));
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cargo vo = new Cargo();
		vo.setCodigo(Integer.parseInt((request.getParameter("id") == null || request.getParameter("id").isBlank()) ?"0":request.getParameter("id")));
		vo.setNome(request.getParameter("nome"));
	    vo.setObservacao(request.getParameter("observacao"));
	    CargoDAO dao = new CargoDAO(vo);
		try {
			response.setContentType("text/html");
			if(vo.getCodigo() > 0) {
				dao.edit();
				out.println("Registro alterado com sucesso!");
			}
			else {
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
