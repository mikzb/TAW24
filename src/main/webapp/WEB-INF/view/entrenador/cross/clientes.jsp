<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Usuario> list = (List<Usuario>) request.getAttribute("listClientes");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Clientes</title>
</head>
<body>
<h1>Tus clientes</h1>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Rutina</th>
    </tr>
    <%
        for(Usuario user: list){
    %>
            <tr>
                <th><%=user.getNombre()%></th>
                <th><%=user.getApellidos()%></th>
                <th><a href="/entrenadorCross/clientes/<%= user.getId() %>/rutinas">Ver Rutinas</a></th>
            </tr>
    <%
        }
    %>
</table>
<button onclick="window.location.href='/entrenadorCross/'">Volver</button>
</body>
</html>
