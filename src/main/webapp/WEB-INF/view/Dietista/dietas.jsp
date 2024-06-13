<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.DietaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<DietaEntity> dietas = (List<DietaEntity>) request.getAttribute("dietas");
%>

<html>
<head>
    <title>dietas</title>
</head>
<body>
<h1>Tus Dietas</h1>

<table border="1">
    <tr>
        <th>Descripción</th>
        <th>Fecha</th>
        <th>Detalles</th>
        <th>Eliminar</th>
    </tr>
    <% for (DietaEntity dieta : dietas) { %>
    <tr>
        <td><%= dieta.getDescripcion() %></td>
        <td><%= dieta.getFechacreacion() %></td>
        <td><a href="/verDietaDietista?id=<%= dieta.getId() %>">Ver Dieta</a></td>
        <td><a href="/eliminarDieta?id=<%= dieta.getId() %>">Eliminar</a></td>
    </tr>
    <% } %>
</table>
<button onclick="window.location.href='/crearDieta'">Crear</button>
<button onclick="window.location.href='/'">Volver</button>
</body>
</html>