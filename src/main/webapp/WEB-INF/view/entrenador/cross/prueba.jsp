<%@ page import="es.uma.taw24.entity.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Rutina</title>
</head>
<body>
<h1>TABLA</h1>
RutinaSesion
<table border="1">
    <tr>
        <th>RUTINAID</th>
        <th>SESIONID</th>
        <th>DIASESEMANA</th>
    </tr>
    <%
        for(RutinaSesionEntity rs: list){
    %>
            <tr>
                <th><%=rs.getIdrutina()%></th>
                <th><%=rs.getIdsesion()%></th>
                <th><%=rs.getDiadesemana()%></th>
            </tr>
    <%
        }
    %>
</table>
<a href="/">Volver</a>
</body>
</html>
