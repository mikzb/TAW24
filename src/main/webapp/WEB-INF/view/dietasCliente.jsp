<%-- Mikolaj Zabski --%>

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

<form:form action="filtrarDietasCliente" method="post" modelAttribute="dieta">
    Buscar: <form:input path="descripcion"/>
    <button>Filtrar</button>
</form:form>

<button onclick="window.location.href='/cliente/dietasCliente'">Quitar Filtro</button>

<table border="1">
    <tr>
        <th>Descripción</th>
        <th>Fecha</th>
        <th>Detalles</th>
    </tr>
    <% for (Dieta dieta : dietas) { %>
    <tr>
        <td><%= dieta.getDescripcion() %></td>
        <td><%= dieta.getFechaCreacion() %></td>
        <td><a href="verDietaCliente?id=<%= dieta.getId() %>">Ver Dieta</a></td>
    </tr>
    <% } %>
</table>
<button onclick="window.location.href='/cliente/'">Volver</button>
</body>
</html>