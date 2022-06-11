<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Colaborador</title>
</head>
<body>
	<form action="CadastroColaborador" method="post">
		<h1>Cadastro de Colaborador</h1>
		Código: <input type="text" name="codigo" id="codigo" /> <br />
		Nome: <input type="text" name="nome" id="nome" /> <br /> 
		Cargo: <input type="text" name="cargo" id="cargo" /> <br />
		E-mail: <input type="text" name="email" id="email" /> <br /> 				
		Observação: <input type="text" name="observacao" id="observacao" /> <br />
		Ativo: <input type="checkbox" name="ativo" id="ativo"><br />
		<br />
		<a href="ListaColaborador">Pesquisar</a> <input type="submit" value="Enviar" />
	</form>
</body>
</html>