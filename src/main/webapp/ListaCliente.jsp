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
<title>Insert title here</title>
</head>
<body>

	<h1>Lista de Clientes</h1>
	<table class="table">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>			
			<th>E-Mail</th>
			<th>Telefone</th>
			<th>Endereço</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>CEP</th>
			<th>CPF</th>
			<th>Ativo</th>
		</tr>
		<c:forEach var="item" items="${lista}" varStatus="contador">
			<tr>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.telefone}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.endereco}" /></td>				
				<td><c:out value="${item.bairro}" /></td>
				<td><c:out value="${item.cidade}" /></td>
				<td><c:out value="${item.cep}" /></td>
				<td><c:out value="${item.cpf}" /></td>
				<td><c:out value="${item.ativo}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>