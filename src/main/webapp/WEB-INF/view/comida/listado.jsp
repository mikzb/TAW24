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
<table border="1">
    <tr>
        <th>Id</th>
        <th>Descripcion</th>
        <th></th>
        <th></th>
    </tr>
    <%
        List<Comida> comidas = (List<Comida>) request.getAttribute("comidas");
        for (Comida comida: comidas) {
    %>
    <tr>
        <td><%= comida.getId() %></td>
        <td><%= comida.getDescripcion() %></td>
        <td><a href="/comida/editar?id=<%= comida.getId() %>">Editar</a></td>
        <td><a href="/comida/borrar?id=<%= comida.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/comida/crear">Nueva comida... </a>
</body>
</html>