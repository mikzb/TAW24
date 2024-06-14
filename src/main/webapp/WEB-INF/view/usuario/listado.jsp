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
<table border="1">
    <tr>
        <th>Email</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Edad</th>
        <th>Sexo</th>
        <th>Permisos</th>
        <th></th>
    </tr>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
    for (Usuario usuario: usuarios) {
%>
        <tr>
            <td><%= usuario.getEmail() %></td>
            <td><%= usuario.getNombre() %></td>
            <td><%= usuario.getApellidos() %></td>
            <td><%= usuario.getEdad() %></td>
            <td><%= usuario.getSexo() %></td>
            <td>A: <%= usuario.isPermisoAdmin()%>, C: <%= usuario.isPermisoCliente()%>, D: <%= usuario.isPermisoDietista()%>, E: <%= usuario.isPermisoEntrenador()%></td>
            <td><a href="/usuario/editar?id=<%= usuario.getId() %>">Editar</a></td>
        </tr>
<%
    }
%>
</table>
<a href="/usuario/crear">Nuevo usuario ... </a>
</body>
</html>