<%-- @author: Mikolaj Zabski --%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="es.uma.taw24.entity.ComidaEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola USUARIO, estoy en dieta</h1>


<h1>Dieta {nombre cliente} {fecha}</h1>

<table>
    <tr>
        <th>Comida ID</th>
        <th>Comida Name</th>
        <!-- Add more columns as needed -->
    </tr>

    <%
        List<ComidaEntity> comidas = (List<ComidaEntity>) request.getAttribute("comidas");
        for (ComidaEntity comida: comidas) {
    %>

    <tr>
        <td><%= comida.getId() %></td>
        <td><%= comida.getDescripcion() %></td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>