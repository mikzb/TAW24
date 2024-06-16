<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="java.util.List" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de usuarios</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>
<h2>
    Lista de usuarios
</h2>
<div style="color: red;">
    ${error}
</div>

<form:form method="post" modelAttribute="filtro" action="/usuario/filtrar">
    <table>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" value="${filtro.email}"/></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><form:input path="nombre" value="${filtro.nombre}"/></td>
        </tr>
        <tr>
            <td>Apellidos:</td>
            <td><form:input path="apellidos" value="${filtro.apellidos}"/></td>
        </tr>
        <tr>
            <td>Edad:</td>
            <td><form:input path="edad" value="${filtro.edad}"/></td>
        </tr>
        <tr>
            <td>Sexo:</td>
            <td><form:input path="sexo" value="${filtro.sexo}"/></td>
        </tr>
        <tr>
            <td>Permisos:</td>
            <td>
                <input type="checkbox" name="permisoAdmin" value="true" ${filtro.permisoAdmin ? 'checked' : ''}>Admin
                <input type="checkbox" name="permisoCliente" value="true" ${filtro.permisoCliente ? 'checked' : ''}>Cliente
                <input type="checkbox" name="permisoDietista" value="true" ${filtro.permisoDietista ? 'checked' : ''}>Dietista
                <input type="checkbox" name="permisoEntrenador" value="true" ${filtro.permisoEntrenador ? 'checked' : ''}>Entrenador
            </td>
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
        <th>Email</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Edad</th>
        <th>Sexo</th>
        <th>Permisos</th>
    </tr>
    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");


        for (Usuario usuario : usuarios) {
    %>
    <tr>
        <td><%= usuario.getEmail() %>
        </td>
        <td><%= usuario.getNombre() %>
        </td>
        <td><%= usuario.getApellidos() %>
        </td>
        <td><%= usuario.getEdad() %>
        </td>
        <td><%= usuario.getSexo() %>
        </td>
        <td>A: <%= usuario.isPermisoAdmin()%>, C: <%= usuario.isPermisoCliente()%>, D: <%= usuario.isPermisoDietista()%>
            , E: <%= usuario.isPermisoEntrenador()%>
        </td>
        <td><a href="/usuario/editar?id=<%= usuario.getId() %>">Editar</a></td>
        <td><a href="/usuario/borrar?id=<%= usuario.getId() %>">Borrar</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/usuario/crear">Nuevo usuario ... </a> <br/>
<button onclick="window.location.href='/usuario/'">Volver al inicio</button>
</body>
</html>