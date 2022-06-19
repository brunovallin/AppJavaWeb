package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PedidoDAO;
import VO.Pedido;

/**
 * Servlet implementation class ApagarPedido
 */
public class ApagarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamou delete");
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	    try {
	    	Pedido vo = new Pedido();	    
		    vo.setCodigoPedido(Integer.parseInt(request.getParameter("codigoPedido")));
		    PedidoDAO dao= new PedidoDAO(vo);
			dao.delete();
			response.setContentType("text/html");
			out.println("Registro Excluido Sucesso");
			
			out.println("<a href='ListaCargo'>Voltar</a>");
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
