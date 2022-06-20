package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import VO.Cliente;

/**
 * Servlet implementation class CadastroCliente
 */
public class CadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente vo = new Cliente();
		vo.setCodigo(Integer.parseInt(request.getParameter("codigo") != null?request.getParameter("codigo"):"0"));
		vo.setNome(request.getParameter("nome"));
		vo.setEmail(request.getParameter("email"));
		vo.setTelefone(request.getParameter("telefone"));
		vo.setEndereco(request.getParameter("endereco"));
		vo.setBairro(request.getParameter("bairro"));
		vo.setCidade(request.getParameter("cidade"));
		vo.setCep(request.getParameter("cep"));
		vo.setCpf(request.getParameter("cpf"));
		vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
		
		request.getRequestDispatcher(request.getServletPath().concat(".jsp")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Cliente vo = new Cliente();

			vo.setCodigo(Integer.parseInt((request.getParameter("codigo") == null || request.getParameter("codigo").isBlank()) ?"0":request.getParameter("codigo")));
			vo.setNome(request.getParameter("nome"));
			vo.setEmail(request.getParameter("email"));
			vo.setTelefone(request.getParameter("telefone"));
			vo.setEndereco(request.getParameter("endereco"));
			vo.setBairro(request.getParameter("bairro"));
			vo.setCidade(request.getParameter("cidade"));
			vo.setCep(request.getParameter("cep"));
			vo.setCpf(request.getParameter("cpf"));
			vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
			
		    ClienteDAO dao = new ClienteDAO(vo);
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
		} catch (Exception e) {
			System.out.println("ERRROR SAVE CLIENTE");
		}
		
	}

}
