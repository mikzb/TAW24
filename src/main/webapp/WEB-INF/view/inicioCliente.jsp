<%-- @author: Mikolaj Zabski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola USUARIO</h1>
<form method="get" action="/cliente/entrenamientoCliente">
    <input type="submit" value="entrenamientoCliente">
</form>
<form method="get" action="/cliente/dietasCliente">
    <input type="submit" value="dietasCliente">
</form>
<form method="get" action="/salir">
    <input type="submit" value="salir">
</form>
<form method="get" action="/usuario/listado">
    <input type="submit" value="listado">
</form>
</body>
</html>