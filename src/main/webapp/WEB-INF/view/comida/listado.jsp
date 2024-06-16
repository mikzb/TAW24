<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Comida" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de comidas</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de comidas
</h2>
<div style="color: red;">
    ${error}
</div>

<form:form method="post" modelAttribute="filtro" action="/comida/filtrar">
    <table>
        <tr>
            <td>Descripcion:</td>
            <td><form:input path="descripcion" value="${filtro.descripcion}"/></td>
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
        <th>Descripcion</th>
        <th></th>
        <th></th>
    </tr>
    <%
        List<Comida> comidas = (List<Comida>) request.getAttribute("comidas");
        for (Comida comida: comidas) {
    %>
    <tr>
        <td><%= comida.getDescripcion() %></td>
        <td><a href="/comida/editar?id=<%= comida.getId() %>">Editar</a></td>
        <td><a href="/comida/borrar?id=<%= comida.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/comida/crear">Nueva comida... </a> <br/>
<button onclick="window.location.href='/usuario/'">Volver al inicio</button>
</body>
</html>