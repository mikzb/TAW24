<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.Rutina" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Rutina> rutinas = (List<Rutina>) request.getAttribute("rutinas");
%>

<html>
<head>
    <title>clientes</title>
</head>
<body>
<h1>Tus Clientes</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Fecha de creación</th>
        <th>Rutina</th>
    </tr>
    <% for (Rutina rutina : rutinas) { %>
    <tr>
        <td><%= rutina.getId() %></td>
        <td><%= rutina.getFechacreacion() %></td>
        <td><a href="/entrenador/clientes/<%= rutina.getId() %>/rutina">Editar Rutina</a></td>
    </tr>
    <% } %>
</table>

<button onclick="window.location.href='/entrenador'">Volver</button>
</body>
</html>