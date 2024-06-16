<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    Integer idCliente = (Integer) request.getAttribute("idCliente");
    List<Usuario> clientes = (List<Usuario>) request.getAttribute("clientes");
%>

<html>
<head>
    <title>Rutinas</title>
</head>
<body>
<h1>Rutinas</h1>

<form:form method="post" action="/entrenador/rutinas/filtrar" modelAttribute="filtro">
    <% if (clientes != null) { %>
    Cliente:
    <form:select path="idCliente">
        <form:option value="0" label="Selecciona un cliente..." />
        <form:options items="${clientes}" itemLabel="nombre" itemValue="id" />
    </form:select>
    <% } else{ %>
    <form:input path="idCliente" type="hidden" value="${idCliente}"/>
    <%
        }
    %>
    Creada después de (dd-MM-yyyy): <form:input path="lowerFecha" />
    Creada antes de (dd-MM-yyyy): <form:input path="upperFecha" />
    <form:button type="submit">Filtrar</form:button>
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
        <td><a href="/entrenador/rutina?id=<%= rutina.getId() %>">Editar Rutina</a></td>
        <td><a href="/entrenador/rutina/borrar?id=<%=rutina.getId()%>">Borrar Rutina</a></td>
    </tr>
    <% } %>
</table>

<%
    if(idCliente != null){
%>
<a href="/entrenador/rutina/anyadir?idCliente=<%=idCliente%>">Añadir rutina</a>
<%
}
else{
%>
<form:form method="post" action="/entrenador/rutina/crear" modelAttribute="cliente">
    Cliente: <form:select path="id" items="${clientes}" itemLabel="nombre" itemValue="id"></form:select>
    <input type="submit" value="Añadir rutina">
</form:form>
<%
    }
%>
<br>
<br>
<button onclick="window.location.href='/entrenador/'">Volver al inicio</button>
</body>
</html>