<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.entity.UsuarioEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Usuario> clientes = (List<Usuario>) request.getAttribute("clientes");
%>

<html>
<head>
    <title>Clientes</title>
</head>
<body>
    <h1>Tus Clientes</h1>

    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Dieta</th>
            <th>Cambiar Dieta</th>
        </tr>
        <% for (Usuario cliente : clientes) { %>
        <tr>
            <td><%= cliente.getNombre() %></td>
            <td><%= cliente.getApellidos() %></td>
            <td><a href="/dietista/verProgresoDieta?id=<%= cliente.getId() %>">Ver Dieta</a></td>
            <td><a href="/dietista/cambiarDietaDietista?id=<%= cliente.getId() %>">Cambiar Dieta</a></td>
        </tr>
        <% } %>
    </table>

    <button onclick="window.location.href='/dietista/'">Volver</button>
</body>
</html>