<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Comida" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de ejercicios</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de ejercicios
</h2>
<table border="1">
    <tr>
        <th>Tipo</th>
        <th>Nombre</th>
        <th>URL</th>
        <th></th>
    </tr>
    <%
        List<Ejercicio> ejercicios = (List<Ejercicio>) request.getAttribute("ejercicios");
        for (Ejercicio ejercicio: ejercicios) {
    %>
    <tr>
        <td><%= ejercicio.getTipo().getNombre() %></td>
        <td><%= ejercicio.getNombre() %></td>
        <td><%= ejercicio.getUrl() %></td>
        <td><a href="/ejercicio/editar?id=<%= ejercicio.getId() %>">Editar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/ejercicio/crear">Nuevo ejercicio... </a>
</body>
</html>