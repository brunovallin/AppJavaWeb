<%@page import="java.util.ArrayList"%> <%@page import="VO.Colaborador"%> <%@page
import="DAO.ColaboradorDAO"%> <%@ page language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Lista de Colaboradores</title>

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
            <h1 style="color: white">Lista de Colaboradores</h1>
            <table class="table" style="color: white">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Cargo</th>
                    <th>E-Mail</th>
                    <th>Observação</th>
                    <th>Ativo</th>
                </tr>
                <c:forEach var="item" items="${lista}" varStatus="contador">
                    <tr>
                        <td><c:out value="${item.codigo}" /></td>
                        <td><c:out value="${item.nome}" /></td>
                        <td><c:out value="${item.cargo}" /></td>
                        <td><c:out value="${item.email}" /></td>
                        <td><c:out value="${item.observacao}" /></td>
                        <td><c:out value="${item.ativo}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
