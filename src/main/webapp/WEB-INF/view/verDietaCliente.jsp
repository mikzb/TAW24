<%--
 Pablo Rubia Arias: 50%
 Mikolaj Zabski 50%
--%>

<%@ page import="es.uma.taw24.entity.DietaEntity" %>
<%@ page import="es.uma.taw24.entity.DietaEntity" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="es.uma.taw24.DTO.Dieta" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Dieta dieta = (Dieta) request.getAttribute("dieta");
%>

<html>
<head>
    <title>Dieta <%= dieta.getId() %> </title>
</head>
<body>
<h1>Dieta número: <%= dieta.getId() %>, Descripción: <%= dieta.getDescripcion() %></h1>

<table border="1">
    <tr>
        <th></th>
        <th>Lunes</th>
        <th>Martes</th>
        <th>Miercoles</th>
        <th>Jueves</th>
        <th>Viernes</th>
        <th>Sábado</th>
        <th>Domingo</th>
    </tr>
    <tr>
        <th>Desayuno</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().getFirst().getDescripcion() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().getFirst().getDescripcion() %></td>
    </tr>
    <tr>
        <th>Almuerzo</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(1).getDescripcion() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(1).getDescripcion() %></td>
    </tr>
    <tr>
        <th>Comida</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(2).getDescripcion() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(2).getDescripcion() %></td>
    </tr>
    <tr>
        <th>Merienda</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(3).getDescripcion() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(3).getDescripcion() %></td>
    </tr>
    <tr>
        <th>Cena</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(4).getDescripcion() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(4).getDescripcion() %></td>
    </tr>
    <tr>
        <th>Completado</th>
        <% for (int i = 0; i < 7; i++) { %>
        <td>
            <%= dieta.getDias().get(i).getMenu().getCompletado() ? "Si" : "No" %>
        </td>
        <% } %>
    </tr>
    <%--
    <tr>
        <th>Completar</th>
        <% for (int i = 0; i < 7; i++) { %>
        <td>
            <form action="/cliente/completarDia" method="post">
                <input type="hidden" name="diaId" value="<%= dieta.getDias().get(i).getId() %>">
                <input type="hidden" name="menuId" value="<%= dieta.getDias().get(i).getMenu().getId() %>">
                <input type="submit" value="Completar">
            </form>
        </td>
        <% } %>
    </tr>
    --%>
</table>
<button onclick="window.location.href='dietasCliente'">Volver</button>
</body>
</html>