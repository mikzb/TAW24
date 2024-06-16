<%-- @author: Mikolaj Zabski --%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="es.uma.taw24.entity.ComidaEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola <%= usuario.getNombre()%> , esta es tu dieta a seguir hoy:</h1>


<h1> Recuerda repartirte las comidas a lo largo del día.
Buen provecho!</h1>

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