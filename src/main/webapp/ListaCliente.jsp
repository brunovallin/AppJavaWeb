<%@page import="java.util.ArrayList"%>
<%@page import="VO.Cliente"%>
<%@page import="DAO.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clientes</title>
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
	<link rel="stylesheet" href="css/global.css" />
</head>
<body>
	<div class="card-body">
		<div class="table-responsive">
		<table class="table table-fixed" style="color: white">
			<thead class="table-info">
				<tr>
					<th class="col-1" scope="col">#</th>
					<th class="col-2" scope="col">Nome</th>
					<th class="col-3" scope="col">E-Mail</th>
					<th class="col-4" scope="col">Telefone</th>
					<th class="col-5" scope="col">Endereço</th>
					<th class="col-6" scope="col">Bairro</th>
					<th class="col-7" scope="col">Cidade</th>
					<th class="col-8" scope="col">CEP</th>
					<th class="col-9" scope="col">CPF</th>
					<th class="col-9" scope="col">Ações</th>
				</tr>
			</thead>
			<tbody class="">
				<c:forEach var="itemCliente" items="${listaClientes}">
					<tr>
						<td scope="row"><c:out value="${itemCliente.codigo}" /></td>
						<td><c:out value="${itemCliente.nome}" /></td>
						<td><c:out value="${itemCliente.email}" /></td>
						<td><c:out value="${itemCliente.telefone}" /></td>
						<td><c:out value="${itemCliente.endereco}" /></td>
						<td><c:out value="${itemCliente.bairro}" /></td>
						<td><c:out value="${itemCliente.cidade}" /></td>
						<td><c:out value="${itemCliente.cep}" /></td>
						<td><c:out value="${itemCliente.cpf}" /></td>
						<td>
							<div class="btn-group">
								<a class="btn btn-dark"	Href="EditarCliente?codigo=<c:out value = "${itemCliente.codigo}"/>">
									<i class="bi bi-pencil-square"></i>
								</a> 
								<a class="btn btn-danger" Href="ApagarCliente?codigo=<c:out value = "${itemCliente.codigo}"/>">
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