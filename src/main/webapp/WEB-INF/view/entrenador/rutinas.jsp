<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.Rutina" %>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Rutina> rutinas = (List<Rutina>) request.getAttribute("rutinas");
%>

<html>
<head>
    <title>Rutinas</title>
</head>
<body>
<h1>Tus Rutinas</h1>

<form:form method="post" action="/entrenador/rutinas/filtrar" modelAttribute="filtro">
    Contiene: <form:input path="titulo" />
    y fue publicado después de: <form:input path="anyo"  />
    <form:button>Filtrar</form:button>

</form:form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Fecha de creación</th>
        <th>Rutina</th>
    </tr>
    <% for (Rutina rutina : rutinas) { %>
    <tr>
        <td><%= rutina.getId() %></td>
        <td><%= Date.from(rutina.getFechacreacion()) %></td>
        <td><a href="/entrenador/editar?id=<%= rutina.getId() %>">Editar Rutina</a></td>
    </tr>
    <% } %>
</table>

<button onclick="window.location.href='/entrenador/'">Volver</button>
</body>
</html>