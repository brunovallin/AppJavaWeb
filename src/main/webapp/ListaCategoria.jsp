<%@page import="java.util.ArrayList"%>
<%@page import="VO.Categoria"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Categorias</title>
</head>
<body>

	<h1>Lista de Categoria</h1>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Descrição</th>
		</tr>
		<c:forEach var="itemCat" items="${listaCat}">
			<tr>
				<td><c:out value="${itemCat.id}" /></td>
				<td><c:out value="${itemCat.nome}" /></td>
				<td><c:out value="${itemCat.descricao}" /></td>
				<td>
		    		<a Href="ApagarCategoria?id=<c:out value = "${itemCat.id}"/>">Apagar</a>  
		    		<a Href="EditarCategoria?id=<c:out value = "${itemCat.id}"/>">Editar</a>   
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>