<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.entity.Dieta" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Dieta dieta = (Dieta) request.getAttribute("dieta");
%>

<html>
<head>
    <title>dieta <%= dieta.getId() %></title>
</head>
<body>
<h1>Dieta id: <%= dieta.getId() %></h1>

<table border="1">
    <tr>
        <th>Lunes</th>
        <th>Martes</th>
        <th>Miercoles</th>
        <th>Jueves</th>
        <th>Viernes</th>
        <th>Sábado</th>
        <th>Domingo</th>
    </tr>
</table>
<button>Editar</button>
<button onclick="window.location.href='/dietas'">Volver</button>
</body>
</html>