<%--
 Pablo Rubia Arias: 100%
--%>

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
<h1>Descripción: <%= dieta.getDescripcion() %></h1>

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
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().getFirst() %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().getFirst() %></td>
    </tr>
    <tr>
        <th>Almuerzo</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(1) %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(1) %></td>
    </tr>
    <tr>
        <th>Comida</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(2) %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(2) %></td>
    </tr>
    <tr>
        <th>Merienda</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(3) %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(3) %></td>
    </tr>
    <tr>
        <th>Cena</th>
        <td><%= dieta.getDias().getFirst().getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(1).getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(2).getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(3).getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(4).getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(5).getMenu().getComidas().get(4) %></td>
        <td><%= dieta.getDias().get(6).getMenu().getComidas().get(4) %></td>
    </tr>
    <tr>
        <th>Completado</th>
        <td> <%= dieta.getDias().getFirst().getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(1).getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(2).getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(3).getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(4).getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(5).getMenu().isCompletado() ? "Si" : "No" %> </td>
        <td> <%= dieta.getDias().get(6).getMenu().isCompletado() ? "Si" : "No" %> </td>
    </tr>
</table>
<button onclick="window.location.href='/dietista/editarDieta?id=<%= dieta.getId() %>'">Editar</button>
<button onclick="window.location.href='/dietista/clientesDietista'">Volver</button>
</body>
</html>