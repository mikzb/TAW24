<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%-- @author: Ignacy Borzestowski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio</title>
</head>
<body>

<jsp:include page="../cabecera.jsp"/>
<table>
    <tr>
        <td>
            <a href="/usuario/listado">Lista de usuarios.</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/usuario/ejercicios">Lista de ejercicos.</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/usuario/comidas">Lista de comidas.</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/usuario/">Lista de algo..</a>
        </td>
    </tr>
</table>

</body>
</html>