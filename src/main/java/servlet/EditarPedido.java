package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import DAO.PedidoDAO;
import VO.Cargo;
import VO.Pedido;

/**
 * Servlet implementation class EditarPedido
 */
public class EditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamou editar");
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Pedido vo = new Pedido();
		try {
			vo.setCodigoPedido(Integer.parseInt(request.getParameter("codigoPedido")));
			PedidoDAO dao = new PedidoDAO(vo);
			dao.load();
			request.setAttribute("vo", dao.getVo());
			request.getRequestDispatcher("/CadastroPedido.jsp").forward(request, response);

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
