<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro de Cargo</title>
</head>
<body>
	<form action="CadastroCargo" method="post">
			<h1>Cadastro de Cargo</h1>
			Nome: <input type="text" name="nome" id="nome" /> <br /> 
			Descrição: <input type="text" name="descricao" id="descricao" /> <br /> 
			<br />
			<a href="ListaCargo.jsp">Pesquisar</a> <input type="submit" value="Enviar" />
	</form>
</body>
</html>