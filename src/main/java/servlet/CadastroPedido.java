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
 * Servlet implementation class CadastroPedido
 */
public class CadastroPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido vo = new Pedido();
		vo.setCodigoPedido(Integer.parseInt(request.getParameter("codigoPedido") != null?request.getParameter("codigoPedido"):"0"));
		vo.setCliente(Integer.parseInt(request.getParameter("cliente")!= null?request.getParameter("cliente"):"0"));
		vo.setVendedor(Integer.parseInt(request.getParameter("vendedor")!= null?request.getParameter("vendedor"):"0"));
		vo.setProduto(Integer.parseInt(request.getParameter("produto")!= null?request.getParameter("produto"):"0"));
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Pedido vo = new Pedido();
		vo.setCodigoPedido(Integer.parseInt((request.getParameter("codigoPedido") == null || request.getParameter("codigoPedido").isBlank()) ?"0":request.getParameter("codigoPedido")));
		vo.setCliente(Integer.parseInt(request.getParameter("cliente")));
		vo.setVendedor(Integer.parseInt(request.getParameter("vendedor")));
		vo.setProduto(Integer.parseInt(request.getParameter("produto")));
		PedidoDAO dao = new PedidoDAO(vo);
		try {
			response.setContentType("text/html");
			if(vo.getCodigoPedido() > 0) {
				dao.edit();
				out.println("Registro alterado com sucesso!");
				out.println("<a href='ListaPedido'>Voltar</a>");
			}
			else {
				dao.save();
				out.println("Registro incluído com sucesso!");
				out.println("<a href='ListaPedido'>Voltar</a>");
			}

			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}

}
