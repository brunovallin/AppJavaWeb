package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.PedidoDAO;
import VO.Pedido;

/**
 * Servlet implementation class ListaPedido
 */
public class ListaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Auto-generated method stub
		PedidoDAO dao = new PedidoDAO();
		
		PrintWriter out = response.getWriter();
		id = request.getParameter("nome");

		try {
			if ( id == null || id.isEmpty()) {
				request.setAttribute("listaPedido", dao.getPedidos());
			} else {
				request.setAttribute("listaPedido", dao.findPedidos(id));	
			}
			request.getRequestDispatcher("/ListaPedido.jsp").forward(request, response);
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
