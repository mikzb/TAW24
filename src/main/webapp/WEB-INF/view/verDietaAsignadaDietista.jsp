<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.entity.DietaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    DietaEntity dieta = (DietaEntity) request.getAttribute("dieta");
%>

<html>
<head>
    <title>dieta <%= dieta.getId() %></title>
</head>
<body>
<h1>Dieta id: <%= dieta.getId() %></h1>

<table border="1">
    <tr>
        <th>Descripción</th>
        <th>Fecha</th>
        <th>Detalles</th>
    </tr>
</table>

<button onclick="window.location.href='/'">Volver</button>
</body>
</html>