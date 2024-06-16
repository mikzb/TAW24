<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%-- @author: Ignacy Borzestowski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio</title>
</head>
<body>

<jsp:include page="../cabecera.jsp"/>

<h3>Listados</h3>
<div style="color: red;">
    ${error}
</div>
<table>
    <tr>
        <td>
            <a href="/usuario/listado">Lista de usuarios</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/ejercicio/listado">Lista de ejercicos</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/comida/listado">Lista de comidas</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/tipo/listado">Lista de tipos de ejercicios</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/grupomuscular/listado">Lista de grupos musculares</a>
        </td>
    </tr>
</table>
</body>
</html>