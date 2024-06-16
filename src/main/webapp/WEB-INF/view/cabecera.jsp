<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%-- @author Ignacy Borzestowski: 100%--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<h1>Hola <%= usuario.getNombre() %></h1>
<form method="get" action="/salir">
    <input type="submit" value="Cerrar sesion">
</form>
<br/>
<br/>