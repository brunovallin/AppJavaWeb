<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
	<%@page import="VO.Colaborador"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro de Colaborador</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>
<body style="background-color: #072227">
	<div class="container">
		<div class="card container mt-5" style="background-color: #35858b">
			<div class="card-body">
				<h3 class="card-title" style="color: white">Cadastro de Colaborador</h3>
				
				<h6 class="card-subtitle mb-2 text-muted mt-3"
					style="color: black !important">Preencha os campos abaixo
				</h6>
				<div class="container card" style="background-color: #4fbdba">
				
					<form action="CadastroColaborador" method="post" class="card-body mt-5 mb-2">
						<div class="d-flex justify-content-between">
							<input type="hidden" name="codigo" id="codigo" value="<c:out value='${vo.codigo}'/>">
							
							<div class="input-group item-group-sm mb-3 mx-4">
								<span class="input-group-text" ><i class="bi bi-tag-fill"></i></span> 
								<input class="form-control" type="text" name="nome" value="<c:out value='${vo.nome}'/>" id="nome" placeholder="Nome" required/>
							</div>
							<div class="input-group item-group-sm mb-3 mx-4">
								<label class="input-group-text" for="name"><i class="bi bi-file-text-fill"></i></label> 
								<input class="form-control" type="text" name="cargo" id="cargo" placeholder="Cargo"value="<c:out value='${vo.cargo}'/>" /> 
							</div>
						</div>
						
						<div class="d-flex justify-content-between">							
							<div class="input-group item-group-sm mb-3 mx-4">
								<span class="input-group-text" ><i class="bi bi-tag-fill"></i></span> 
								<input class="form-control" type="text" name="email" value="<c:out value='${vo.email}'/>" id="email" placeholder="E-mail" required/>
							</div>
							<div class="input-group item-group-sm mb-3 mx-4">
								<label class="input-group-text" for="name"><i class="bi bi-file-text-fill"></i></label> 
								<input class="form-control" type="text" name="observacao" id="observacao" placeholder="Observação"value="<c:out value='${vo.observacao}'/>" /> 
							</div>
							<input type="hidden" name="ativo" id="ativo" value="<c:out value='${vo.ativo}'/>">
						</div>
						
						
						<div class="d-flex justify-content-end mb-3 me-4">
							<div class="btn-group">
								<a class="btn btn-outline-dark" href=pesquisaPorNome()>Pesquisar</a>
								<button class="btn btn-dark" type="submit" >Enviar</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>