<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Añadir nuevo ejercicio</title>
</head>
<body>

<h1>Datos</h1>

<form:form method="post" action="/entrenador/sesion/guardar" modelAttribute="rutinaSesion">
    <form:hidden path="sesion.id"/>
    <form:hidden path="rutina.id"/>

    <table border="0">
        <tr>
            <td>Día:</td>
            <td> <form:select path="diadesemana">
                <form:option value="1">Lunes</form:option>
                <form:option value="2">Martes</form:option>
                <form:option value="3">Miércoles</form:option>
                <form:option value="4">Jueves</form:option>
                <form:option value="5">Viernes</form:option>
                <form:option value="6">Sábado</form:option>
                <form:option value="7">Domingo</form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"> <button>Enviar</button></td>
        </tr>
    </table>
</form:form>

<a href="/entrenador/">Volver atrás.</a>

</body>
</html>
