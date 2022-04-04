<%@page import="java.util.ArrayList"%>
<%@page import="VO.Pedido"%>
<%@page import="DAO.PedidoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Pedidos</title>
</head>
<body>

	<h1>Lista de Pedidos</h1>
	<table class="table">
		<tr>
			<th>Codigo Pedido</th>
			<th>Cliente</th>			
			<th>Vendedor</th>
			<th>Produto</th>			
		</tr>
		<c:forEach var="item" items="${lista}" varStatus="contador">
			<tr>
				<td><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.cliente}" /></td>
				<td><c:out value="${item.vendedor}" /></td>
				<td><c:out value="${item.produto}" /></td>							
			</tr>
		</c:forEach>
	</table>
</body>
</html>