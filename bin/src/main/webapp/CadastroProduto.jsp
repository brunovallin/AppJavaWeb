<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro de Produto</title>
</head>
<body>
	<form action="CadastroProduto" method="post">
		<h1>Cadastro de Categoria</h1>
		Código: <input type="text" name="codigo" id="codigo" /> <br />
		Nome: <input type="text" name="nome" id="nome" /> <br /> 
		Descrição: <input type="text" name="descricao" id="descricao" /> <br /> 
		EAN: <input type="text" name="ean" id="ean" /> <br />
		Categoria:
		<select name="categoria" id="categoria">
			<option>Categoria 1</option>
			<option>Categoria 2</option>
			<option>Categoria 3</option>
		</select> <br />
		Preço: <input type="text" name="preco" id="preco" /> <br />
		Ativo: <input type="text" name="categoria" id="categoria" /> <br />
		<br />
		<a href="ListaProduto">Pesquisar</a> <input type="submit" value="Enviar" />
	</form>
</body>
</html>