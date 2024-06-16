<%@ page import="es.uma.taw24.entity.RutinaEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola USUARIO, estoy en entrenamientoCliente</h1>

<table>
    <tr>
        <th>Número</th>
        <th>Fecha de creación</th>
        <!-- Add more columns as needed -->
    </tr>
    <%
        List<RutinaEntity> rutinas = (List<RutinaEntity>) request.getAttribute("rutinas");
        for (RutinaEntity rutina : rutinas) {
    %>
    <tr>
        <td><%= rutina.getId() %></td>
        <td><%= rutina.getFechacreacion() %></td>
        <td>
        <form action="/cliente/rutinaDetalle" method="get">
            <input type="hidden" name="rutinaId" value="<%= rutina.getId() %>">
            <input type="submit" value="View Details">
        </form></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>