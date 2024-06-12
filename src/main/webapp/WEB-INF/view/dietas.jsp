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
    </tr>
    <% for (DietaEntity dieta : dietas) { %>
    <tr>
        <td><%= dieta.getDescripcion() %></td>
        <td><%= dieta.getFechaCreacion() %></td>
        <td><a>Ver Dieta</a></td>
    </tr>
    <% } %>
</table>

<button onclick="window.location.href='/'">Volver</button>
</body>
</html>