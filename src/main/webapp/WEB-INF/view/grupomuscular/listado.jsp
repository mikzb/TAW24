<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Comida" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.GrupoMuscular" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de grupos musculares</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de grupos musculares
</h2>
<div style="color: red;">
    ${error}
</div>

<form:form method="post" modelAttribute="filtro" action="/grupomuscular/filtrar">
    <table>
        <tr>
            <td>Nombre:</td>
            <td><form:input path="nombre" value="${filtro.nombre}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button>Filtrar</button>
            </td>
        </tr>
    </table>
</form:form>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th></th>
        <th></th>
    </tr>
    <%
        List<GrupoMuscular> gruposMusculares = (List<GrupoMuscular>) request.getAttribute("gruposmusculares");
        for (GrupoMuscular grupoMuscular: gruposMusculares) {
    %>
    <tr>
        <td><%= grupoMuscular.getNombre() %></td>
        <td><a href="/grupomuscular/editar?id=<%= grupoMuscular.getId() %>">Editar</a></td>
        <td><a href="/grupomuscular/borrar?id=<%= grupoMuscular.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/grupomuscular/crear">Nuevo grupo muscular... </a> <br/>
<button onclick="window.location.href='/usuario/'">Volver al inicio</button>
</body>
</html>