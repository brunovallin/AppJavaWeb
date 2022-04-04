<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>
	<form action="CadastroCliente" method="post">
		<h1>Cadastro de Cliente</h1>
		Código: <input type="text" name="codigo" id="codigo" /> <br />
		Nome: <input type="text" name="nome" id="nome" /> <br /> 
		E-mail: <input type="text" name="email" id="email" /> <br /> 
		Telefone: <input type="text" name="telefone" id="telefone" /> <br />
		Endereço: <input type="text" name="endereco" id="endereco" /> <br />
		Bairro: <input type="text" name="bairro" id="bairro" /> <br />
		Cidade: <input type="text" name="cidade" id="cidade" /> <br />
		CEP: <input type="text" name="cidade" id="cidade" /> <br />
		CPF: <input type="text" name="cpf" id="cpf" /> <br />
		<br />
		<a href="ListaCliente.jsp">Pesquisar</a> <input type="submit" value="Enviar" />
	</form>
</body>
</html>