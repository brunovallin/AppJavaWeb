package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import VO.Cargo;

/**
 * Servlet implementation class EditarCargo
 */
public class EditarCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCargo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Cargo vo = new Cargo();
		try {
			vo.setCodigo(Integer.parseInt(request.getParameter("id")));
			CargoDAO dao = new CargoDAO(vo);
			dao.load();
			request.setAttribute("vo", dao.getVo());
			request.getRequestDispatcher("/CadastroCargo.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
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
