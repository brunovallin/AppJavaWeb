<%@page import="java.util.ArrayList"%>
<%@page import="VO.Produto"%>
<%@page import="DAO.ProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Produtos</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous" />
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css" />
	<link rel="stylesheet" href="css/global.css"/>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand-lg btn-dark" href="/PrimeiroApp/Home"><i class="bi bi-house-fill"></i></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="CadastroCategoria">Categoria</a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="CadastroCliente">Cliente</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CadastroColaborador">Colaborador</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CadastroCargo">Cargo</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CadastroPedido">Pedido</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CadastroProduto">Produto</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-fixed" style="color: white">
				<thead class="table-info">
					<tr>
						<th class="col-1" scope="col">#</th>
						<th class="col-3" scope="col">Nome</th>
						<th class="col-5" scope="col">Descrição</th>
						<th class="col-3" scope="col">EAN</th>
						<th class="col-5" scope="col">Categoria</th>
						<th class="col-3" scope="col">preco</th>
						<th class="col-5" scope="col">Ativo</th>
						<th class="col-2" scope="col">Ações</th>
					</tr>
				</thead>
				<tbody class="">
					<c:forEach var="itemProduto" items="${listaProduto}">
						<tr>
							<td scope="row"><c:out value="${itemProduto.codigo}" /></td>
							<td><c:out value="${itemProduto.nome}" /></td>
							<td><c:out value="${itemProduto.descricao}" /></td>
							<td><c:out value="${itemProduto.ean}" /></td>
							<td><c:out value="${itemProduto.categoria}" /></td>
							<td><c:out value="${itemProduto.preco}" /></td>
							<td><c:out value="${itemProduto.ativo}" /></td>
							<td>
								<div class="btn-group">
									<a class="btn btn-dark"	Href="EditarProduto?codigo=<c:out value = "${itemProduto.codigo}"/>">
										<i class="bi bi-pencil-square"></i>
									</a> 
									<a class="btn btn-danger" Href="ApagarProduto?codigo=<c:out value = "${itemProduto.codigo}"/>">
										<i class="bi bi-trash"></i>
									</a>
								</div>
							</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>