<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%-- @author: Ignacy Borzestowski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<jsp:include page="cabecera.jsp"/>

<% if (usuario.isPermisoAdmin()) { %>
    <form method="get" action="/usuario/">
        <input type="submit" value="Inicio de usuario">
    </form>
<% } %>
<% if (usuario.isPermisoCliente()) { %>
    <form method="get" action="/cliente/">
        <input type="submit" value="Inicio de cliente">
    </form>
<% } %>
<% if (usuario.isPermisoEntrenador()) { %>
    <form method="get" action="/entrenador/">
        <input type="submit" value="Inicio de entrenador">
    </form>
<% } %>
<% if (usuario.isPermisoDietista()) { %>
    <form method="get" action="/dietista/">
        <input type="submit" value="Inicio de dietista">
    </form>
<% } %>
</body>
</html>