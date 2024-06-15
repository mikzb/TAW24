<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="es.uma.taw24.DTO.RutinaSesion" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Rutina Cliente</title>
</head>
<body>

<%
    List<RutinaSesion> rutinaSesiones = (List<RutinaSesion>) request.getAttribute("rutinaSesiones");
%>

<h1>Rutinas del Cliente</h1>

<h2>Tabla de Rutinas</h2>
<table border="1">
    <thead>
    <tr>
        <th>SESIÓN</th>
        <th>DÍA</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%
            for(RutinaSesion rs : rutinaSesiones){
        %>
        <tr>
        <td><a href="/entrenador/sesion?id=<%=rs.getIdsesion().getId()%>">Sesión <%=rs.getIdsesion().getId()%></a></td>
        <td><%=rs.getDiadesemana()%></td>
        <td><a href="/entrenador/sesion/borrar?id=" <%=rs.getIdsesion().getId()%>>Borrar</a></td>
        </tr>
        <%
            }
        %>
    </tr>
    </tbody>
</table>

<a href="/entrenador/sesion/crear">Crear nueva sesión.</a>

</body>
</html>
