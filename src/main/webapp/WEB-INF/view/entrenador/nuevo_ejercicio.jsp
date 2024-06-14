<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Añadir nuevo ejercicio</title>
</head>
<body>

<h1>Datos</h1>

<form:form method="post" action="/entrenador/guardar_ejercicio" modelAttribute="sesionEjercicio">
    <form:hidden path="sesion.id"/>

    <table border="0">
        <tr>
            <td>Ejercicio:</td>
            <td> <form:select path="ejercicio.id" items="${ejercicios}" itemLabel="nombre" itemValue="id" />
            </td>
        </tr>
        <tr>
            <td>Series:</td>
            <td><form:input path="series" size="4"  maxlength="4" />
            </td>
        </tr>
        <tr>
            <td>Repeticiones:</td>
            <td><form:input path="repeticiones" size="4"  maxlength="4" />
            </td>
        </tr>
        <tr>
            <td>Peso:</td>
            <td><form:input path="peso" size="4"  maxlength="4" />
            </td>
        </tr>
        <tr>
            <td>Completado:</td>
            <td><form:checkbox path="completado" />
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
