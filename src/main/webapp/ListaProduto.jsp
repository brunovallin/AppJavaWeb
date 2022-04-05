<%@page import="java.util.ArrayList"%> <%@page import="VO.Produto"%> <%@ page 
language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%@ taglib
uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Lista de Produtos</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
        />
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"
        ></script>
    </head>
    <body style="background-color: #072227">
        <div class="container">
            <h1 style="color: white">Lista de Produtos</h1>

            <table class="table" style="color: white">
                <tr>
                    <td>Codigo</td>
                    <td>Nome</td>
                    <td>Descri��o</td>
                    <td>EAN</td>
                    <td>Categoria</td>
                    <td>Pre�o</td>
                    <td>Ativo</td>
                </tr>

                <c:forEach var="item" items="${lista}"  varStatus="contador">
                    <tr>
                        <td>
                        	<c:out value="${item.codigo}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.nome}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.descricao}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.ean}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.categoria}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.preco}"></c:out>
                        </td>
                        
                        <td>
                        	<c:out value="${item.ativo}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
