<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Categoria</title>
	</head>
	<body>
		<form action="CadastroCategoria" method="post">
			<h1>Cadastro de Categoria</h1>
			Nome: <input type="text" name="nome" id="nome" /> <br /> 
			Descrição: <input type="text" name="descricao" id="descricao" /> <br /> 
			<br />
			<a href="ListaCategoria.jsp">Pesquisar</a> <input type="submit" value="Enviar" />
		</form>
	</body>
</html>