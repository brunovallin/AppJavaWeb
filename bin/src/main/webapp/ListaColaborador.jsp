<%@page import="java.util.ArrayList"%>
<%@page import="VO.Colaborador"%>
<%@page import="DAO.ColaboradorDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Colaboradores</title>
</head>
<body>

	<h1>Lista de Colaboradores</h1>
	<table class="table">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>			
			<th>Cargo</th>
			<th>E-Mail</th>
			<th>Observação</th>			
			<th>Ativo</th>
		</tr>
		<c:forEach var="item" items="${lista}" varStatus="contador">
			<tr>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.nome}" /></td>
				<td><c:out value="${item.cargo}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.observacao}" /></td>				
				<td><c:out value="${item.ativo}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>