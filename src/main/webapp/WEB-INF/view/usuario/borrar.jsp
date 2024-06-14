<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Borrar usuario</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<h2> Estas seguro que quieres borrar el usuario con email: <%= usuario.getEmail()%>? </h2>
<div style="color: red;">
    ${error}
</div>
<form:form modelAttribute="usuario" action="/usuario/borrar" method="post">
    <form:hidden path="id" />
    <form:button type="submit" value="Borrar">Borrar</form:button>
</form:form>
</body>
</html>