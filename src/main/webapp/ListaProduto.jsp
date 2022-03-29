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
<title>Lista de Produtos</title>
</head>
<body>

	<h1>Lista de Produtos</h1>
	<table class="table">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>			
			<th>Descrição</th>
			<th>EAN</th>
			<th>Categoria</th>
			<th>Preço</th>
			<th>Ativo</th>
		</tr>
		<c:forEach var="item" items="${lista}" varStatus="contador">
			<tr>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.descricao}" /></td>
				<td><c:out value="${item.ean}" /></td>				
				<td><c:out value="${item.categoria}" /></td>
				<td><c:out value="${item.preco}" /></td>
				<td><c:out value="${item.ativo}" /></td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>