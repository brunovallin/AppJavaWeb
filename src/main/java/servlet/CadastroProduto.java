package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import DAO.ColaboradorDAO;
import DAO.ProdutoDAO;
import VO.Categoria;
import VO.Colaborador;
import VO.Produto;

/**
 * Servlet implementation class Cadastro
 */
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastroProduto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto vo = new Produto();
		vo.setCodigo(Integer.parseInt(request.getParameter("codigo") != null?request.getParameter("codigo"):"0"));
		vo.setNome(request.getParameter("nome"));
		vo.setDescricao(request.getParameter("descricao"));
		vo.setEan(Long.parseLong(request.getParameter("ean")));
		vo.setCategoria(request.getParameter("categoria"));
		vo.setPreco(Double.parseDouble(request.getParameter("preco")));
		vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Produto vo = new Produto();
		
		vo.setCodigo(Integer.parseInt((request.getParameter("codigo") == null || request.getParameter("codigo").isBlank()) ?"0":request.getParameter("codigo")));
		vo.setNome(request.getParameter("nome"));
		vo.setDescricao(request.getParameter("descricao"));
	    vo.setEan(Long.parseLong(request.getParameter("ean")));
	    vo.setCategoria( request.getParameter("categoria"));
	    vo.setPreco(Double.parseDouble(request.getParameter("preco")));
	    vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
	    ProdutoDAO dao = new ProdutoDAO(vo);
		try {
			response.setContentType("text/html");
			if(vo.getCodigo() > 0) {
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
