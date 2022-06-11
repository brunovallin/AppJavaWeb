<%@page import="java.util.ArrayList"%>
<%@page import="VO.Cargo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cargos</title>
</head>
<body>
	<h1>Lista de Cargos</h1>
	<table class="table">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Observação</th>
			<th>Ativo</th>
		</tr>
		<c:forEach var="item" items="${lista}" varStatus="contador">
			<tr>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.observacao}" /></td>
				<td><c:out value="${item.ativo}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>