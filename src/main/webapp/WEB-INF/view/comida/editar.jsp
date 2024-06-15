<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.Entrenador" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Comida" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editar comida</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>

<% Comida comida = (Comida) request.getAttribute("comida"); %>

<h2> Editar comida </h2>
<div style="color: red;">
    ${error}
</div>
<form:form modelAttribute="comida" action="/comida/editar" method="post">
    <table>
        <tr>
            <td>
                <form:hidden path="id" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="descripcion">Descripcion: </form:label>
            </td>
            <td>
                <form:textarea maxlength="150" path="descripcion" />
            </td>
        </tr>
    </table>
    <input type="submit" value="Editar"/>
</form:form>
</body>
</html>