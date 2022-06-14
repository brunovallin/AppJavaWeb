<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="VO.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Categoria</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>
<body style="background-color: #072227">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
	<script src="js/ListaCategoria.js"></script>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand-lg btn-dark" href="/PrimeiroApp/Home"><i class="bi bi-house-fill"></i></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="CadastroCategoria" style="color: white">Categoria</a>
	        </li>
	        <li class="nav-item">
	          		<a class="nav-link" href="CadastroProduto" >Produto</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Pricing</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<div class="container">
		<div class="card container mt-5" style="background-color: #35858b">
			<div class="card-body">
				<h3 class="card-title" style="color: white">Cadastro de Categoria</h3>
				<h6 class="card-subtitle mb-2 text-muted mt-3"
					style="color: black !important">Preencha os campos abaixo</h6>
				<div class="container card" style="background-color: #4fbdba">
					<form action="CadastroCategoria" method="post" class="card-body mt-5 mb-2">
						<div class="d-flex justify-content-between">
							<input type="hidden" name="id" id="id" value="<c:out value='${vo.id}'/>">
							<div class="input-group item-group-sm mb-3 mx-4">
								<span class="input-group-text" ><i class="bi bi-tag-fill"></i></span> 
								<input class="form-control" type="text" name="nome" value="<c:out value='${vo.nome}'/>" id="nome" placeholder="Nome" required/>
							</div>
							<div class="input-group item-group-sm mb-3 mx-4">
								<label class="input-group-text" for="name"><i class="bi bi-file-text-fill"></i></label> 
								<input class="form-control" type="text" name="descricao" id="descricao" placeholder="Descri��o"value="<c:out value='${vo.descricao}'/>" /> 
							</div>
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