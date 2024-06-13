<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.entity.DietaEntity" %>
<%@ page import="es.uma.taw24.entity.DietaEntity" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    DietaEntity dieta = (DietaEntity) request.getAttribute("dieta");
    Map<Instant, List<String>> menus = (Map<Instant, List<String>>) request.getAttribute("menus");
    List<Instant> fechas = menus.keySet().stream().sorted().collect(Collectors.toList());
    List<Boolean> completados = (List<Boolean>) request.getAttribute("completados");
%>

<html>
<head>
    <title>Dieta<%= dieta.getId() %> </title>
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
        <td><%= menus.get(fechas.getFirst()).getFirst() %></td>
        <td><%= menus.get(fechas.get(1)).getFirst() %></td>
        <td><%= menus.get(fechas.get(2)).getFirst() %></td>
        <td><%= menus.get(fechas.get(3)).getFirst() %></td>
        <td><%= menus.get(fechas.get(4)).getFirst() %></td>
        <td><%= menus.get(fechas.get(5)).getFirst() %></td>
        <td><%= menus.get(fechas.get(6)).getFirst() %></td>
    </tr>
    <tr>
        <th>Almuerzo</th>
        <td><%= menus.get(fechas.getFirst()).get(1) %></td>
        <td><%= menus.get(fechas.get(1)).get(1) %></td>
        <td><%= menus.get(fechas.get(2)).get(1) %></td>
        <td><%= menus.get(fechas.get(3)).get(1) %></td>
        <td><%= menus.get(fechas.get(4)).get(1) %></td>
        <td><%= menus.get(fechas.get(5)).get(1) %></td>
        <td><%= menus.get(fechas.get(6)).get(1) %></td>
    </tr>
    <tr>
        <th>Comida</th>
        <td><%= menus.get(fechas.getFirst()).get(2) %></td>
        <td><%= menus.get(fechas.get(1)).get(2) %></td>
        <td><%= menus.get(fechas.get(2)).get(2) %></td>
        <td><%= menus.get(fechas.get(3)).get(2) %></td>
        <td><%= menus.get(fechas.get(4)).get(2) %></td>
        <td><%= menus.get(fechas.get(5)).get(2) %></td>
        <td><%= menus.get(fechas.get(6)).get(2) %></td>
    </tr>
    <tr>
        <th>Merienda</th>
        <td><%= menus.get(fechas.getFirst()).get(3) %></td>
        <td><%= menus.get(fechas.get(1)).get(3) %></td>
        <td><%= menus.get(fechas.get(2)).get(3) %></td>
        <td><%= menus.get(fechas.get(3)).get(3) %></td>
        <td><%= menus.get(fechas.get(4)).get(3) %></td>
        <td><%= menus.get(fechas.get(5)).get(3) %></td>
        <td><%= menus.get(fechas.get(6)).get(3) %></td>
    </tr>
    <tr>
        <th>Cena</th>
        <td><%= menus.get(fechas.getFirst()).get(4) %></td>
        <td><%= menus.get(fechas.get(1)).get(4) %></td>
        <td><%= menus.get(fechas.get(2)).get(4) %></td>
        <td><%= menus.get(fechas.get(3)).get(4) %></td>
        <td><%= menus.get(fechas.get(4)).get(4) %></td>
        <td><%= menus.get(fechas.get(5)).get(4) %></td>
        <td><%= menus.get(fechas.get(6)).get(4) %></td>
    </tr>
    <tr>
        <th>Completado</th>
        <td> <%= completados.get(0) ? "Si" : "No" %> </td>
        <td> <%= completados.get(1) ? "Si" : "No" %> </td>
        <td> <%= completados.get(2) ? "Si" : "No" %> </td>
        <td> <%= completados.get(3) ? "Si" : "No" %> </td>
        <td> <%= completados.get(4) ? "Si" : "No" %> </td>
        <td> <%= completados.get(5) ? "Si" : "No" %> </td>
        <td> <%= completados.get(6) ? "Si" : "No" %> </td>
    </tr>
</table>
<button>Editar</button>
<button onclick="window.location.href='/clientesDietista'">Volver</button>
</body>
</html>