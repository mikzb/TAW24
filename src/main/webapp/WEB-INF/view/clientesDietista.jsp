<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.entity.Usuario" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Usuario> clientes = (List<Usuario>) request.getAttribute("clientes");
%>

<html>
<head>
    <title>clientes</title>
</head>
<body>
    <h1>Tus Clientes</h1>

    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Dieta</th>
        </tr>
        <% for (Usuario cliente : clientes) { %>
        <tr>
            <td><%= cliente.getNombre() %></td>
            <td><%= cliente.getApellidos() %></td>
            <td><a href="/verDietaAsignada?id=<%= cliente.getId() %>">Ver Dieta</a></td>
        </tr>
        <% } %>
    </table>

    <button onclick="window.location.href='/'">Volver</button>
</body>
</html>