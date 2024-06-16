<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Tipo" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de tipos de ejercicios</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de tipos de ejercicios
</h2>
<div style="color: red;">
    ${error}
</div>

<form:form method="post" modelAttribute="filtro" action="/tipo/filtrar">
    <table>
        <tr>
            <td>Nombre:</td>
            <td><form:input path="nombre" value="${filtro.nombre}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button>Filtrar</button>
            </td>
        </tr>
    </table>
</form:form>

<table border="1">
    <tr>
        <th>Nombre</th>
        <th></th>
        <th></th>
    </tr>
    <%
        List<Tipo> tipos = (List<Tipo>) request.getAttribute("tipos");
        for (Tipo tipo: tipos) {
    %>
    <tr>
        <td><%= tipo.getNombre() %></td>
        <td><a href="/tipo/editar?id=<%= tipo.getId() %>">Editar</a></td>
        <td><a href="/tipo/borrar?id=<%= tipo.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/tipo/crear">Nuevo tipo de ejercicio... </a> <br/>
<button onclick="window.location.href='/usuario/'">Volver al inicio</button>
</body>
</html>