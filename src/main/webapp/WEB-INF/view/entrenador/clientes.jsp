<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>

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
        <th>Rutinas</th>
    </tr>
    <% for (Usuario cliente : clientes) { %>
    <tr>
        <td><%= cliente.getNombre() %></td>
        <td><%= cliente.getApellidos() %></td>
        <td><a href="/entrenador/cliente/<%= cliente.getId() %>/rutinas">Ver Rutinas</a></td>
    </tr>
    <% } %>
</table>
<br>
<br>
<button onclick="window.location.href='/entrenador/'">Volver al inicio</button>
</body>
</html>