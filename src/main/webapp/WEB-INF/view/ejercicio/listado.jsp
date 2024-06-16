<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.GrupoMuscular" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de ejercicios</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de ejercicios
</h2>

<div style="color: red;">
    ${error}
</div>
<form:form method="post" modelAttribute="filtro" action="/ejercicio/filtrar">
    <table>
        <tr>
            <td>Nombre:</td>
            <td><form:input path="nombre" value="${filtro.nombre}"/></td>
        </tr>
        <tr>
            <td>Tipo:</td>
            <td><form:input path="tipo" value="${filtro.tipo}"/></td>
        </tr>
        <tr>
            <td>Grupo muscular:</td>
            <td><form:input path="grupoMuscular" value="${filtro.grupoMuscular}"/></td>
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
        <th>Tipo</th>
        <th>Nombre</th>
        <th>URL</th>
        <th>Grupos musculares</th>
        <th></th>
        <th></th>
    </tr>
    <%
        List<Ejercicio> ejercicios = (List<Ejercicio>) request.getAttribute("ejercicios");
        Map<Integer, List<GrupoMuscular>> gruposPorEjercicio = (Map<Integer, List<GrupoMuscular>>) request.getAttribute("gruposPorEjercicio");
        if (ejercicios == null) ejercicios = new ArrayList<>();
        if (gruposPorEjercicio == null) gruposPorEjercicio = new HashMap<>();
        for (Ejercicio ejercicio: ejercicios) {
    %>
    <tr>
        <td><%= ejercicio.getTipo().getNombre() %></td>
        <td><%= ejercicio.getNombre() %></td>
        <td><a href="<%= ejercicio.getUrl() %>">Video</a></td>
        <td>
            <%
                List<GrupoMuscular> gruposMusculares = gruposPorEjercicio.get(ejercicio.getId());
                if (gruposMusculares != null) {
                    for (GrupoMuscular grupo : gruposMusculares) {
            %>
            <span><%= grupo.getNombre() %>, </span>
            <%
                    }
                }
            %>
        </td>
        <td><a href="/ejercicio/editar?id=<%= ejercicio.getId() %>">Editar</a></td>
        <td><a href="/ejercicio/borrar?id=<%= ejercicio.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/ejercicio/crear">Nuevo ejercicio... </a>
</body>
</html>