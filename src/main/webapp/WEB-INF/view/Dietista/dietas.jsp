<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Dieta" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Dieta> dietas = (List<Dieta>) request.getAttribute("dietas");
%>

<html>
<head>
    <title>Dietas</title>
</head>
<body>
<h1>Tus Dietas</h1>

<form:form action="/dietista/filtrarDietas" method="post" modelAttribute="dieta">
    Buscar: <form:input path="descripcion"/>
    <button>Filtrar</button>
</form:form>

<button onclick="window.location.href='/dietista/dietas'">Quitar Filtro</button>

<table border="1">
    <tr>
        <th>Descripción</th>
        <th>Fecha</th>
        <th>Detalles</th>
        <th>Eliminar</th>
    </tr>
    <% for (Dieta dieta : dietas) { %>
    <tr>
        <td><%= dieta.getDescripcion() %></td>
        <td><%= dieta.getFechaCreacion() %></td>
        <td><a href="/dietista/verDietaDietista?id=<%= dieta.getId() %>">Ver Dieta</a></td>
        <td><a href="/dietista/eliminarDieta?id=<%= dieta.getId() %>">Eliminar</a></td>
    </tr>
    <% } %>
</table>
<button onclick="window.location.href='/dietista/crearDieta?id=0'">Crear</button>
<button onclick="window.location.href='/dietista/'">Volver</button>
</body>
</html>