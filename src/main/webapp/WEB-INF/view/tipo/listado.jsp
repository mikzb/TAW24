<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Comida" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.GrupoMuscular" %>
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
        <td><a href="/grupomuscular/editar?id=<%= tipo.getId() %>">Editar</a></td>
        <td><a href="/grupomuscular/borrar?id=<%= tipo.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/grupomuscular/crear">Nuevo grupo muscular... </a>
</body>
</html>