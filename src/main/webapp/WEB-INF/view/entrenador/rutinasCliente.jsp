<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Rutina Cliente</title>
</head>
<body>
<h1>Rutinas del Cliente</h1>

<form:form method="post" action="/rutinas/guardar" modelAttribute="rutinaForm">
    <table border="0">
        <tr>
            <td>Ejercicio:</td>
            <td>
                <form:select path="ejercicio">
                    <form:option value="" label="Seleccione un ejercicio" />
                    <form:option value="Ejercicio 1" label="Ejercicio 1" />
                    <form:option value="Ejercicio 2" label="Ejercicio 2" />
                    <form:option value="Ejercicio 3" label="Ejercicio 3" />
                    <!-- Añade más opciones de ejercicios según sea necesario -->
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Series:</td>
            <td>
                <form:input path="series" type="number" min="1" />
            </td>
        </tr>
        <tr>
            <td>Repeticiones:</td>
            <td>
                <form:input path="repeticiones" type="number" min="1" />
            </td>
        </tr>
        <tr>
            <td>Peso:</td>
            <td>
                <form:input path="peso" type="number" min="1" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Añadir/Actualizar</button>
                <button type="submit" formaction="/rutinas/eliminar">Eliminar</button>
            </td>
        </tr>
    </table>
</form:form>

<h2>Tabla de Rutinas</h2>
<table border="1">
    <thead>
    <tr>
        <th>L</th>
        <th>M</th>
        <th>X</th>
        <th>J</th>
        <th>V</th>
        <th>S</th>
        <th>D</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${rutinasSemana}" var="rutinaDia">
            <td>
                <form:form method="post" action="/rutinas/seleccionar" modelAttribute="rutinaSeleccionada">
                    <form:hidden path="dia" value="${rutinaDia.dia}" />
                    <form:input path="ejercicio" value="${rutinaDia.ejercicio}" readonly="true" />
                    <form:input path="series" value="${rutinaDia.series}" readonly="true" />
                    <form:input path="repeticiones" value="${rutinaDia.repeticiones}" readonly="true" />
                    <form:input path="peso" value="${rutinaDia.peso}" readonly="true" />
                    <button type="submit">Seleccionar</button>
                </form:form>
            </td>
        </c:forEach>
    </tr>
    </tbody>
</table>

</body>
</html>
