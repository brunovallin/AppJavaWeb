<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pedidos</title>
</head>
<body>
	<form action="CadastroPedido" method="post">
		<h1>Cadastro de Pedidos</h1>
		Código do Pedido: <input type="text" name="codigoPedido" id="codigoPedido" /> <br />
		Cliente: <input type="text" name="cliente" id="cliente" /> <br />
		Vendedor: <input type="text" name="vendedor" id="vendedor" /> <br />
		Produto: <input type="text" name="produto" id="produto" /> <br />		
		<br />
		<a href="ListaPedido.jsp">Pesquisar</a> <input type="submit" value="Enviar" />
	</form>
</body>
</html>