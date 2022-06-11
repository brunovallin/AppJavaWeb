<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page import="VO.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Categoria</title>
</head>
<body>
	<form action="CadastroCategoria" method="post">
	    <h1>Cadastro de Categoria</h1>
	    <input type="hidden" name="id" id="id" value="<c:out value='${vo.id}'/>">
		    Nome:     <input type="text" name="nome" 
		    value="<c:out value='${vo.nome}'/>" id="nome" />
		<br />
			Descrição: <input type="text" name="descricao" 
			 value="<c:out value='${vo.descricao}'/>" id="descricao" />			
		<br />
		<br />
		<a href="ListaCategoria">Pesquisar</a>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>