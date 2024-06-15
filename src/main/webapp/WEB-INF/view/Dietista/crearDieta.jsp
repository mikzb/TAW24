<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Crear Dieta</title>
</head>
<body>
<h1>Crear Nueva Dieta</h1>
    <form:form method="post" action="/dietista/guardarCreacionDieta" modelAttribute="dieta">
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
                <td><form:select path="dias[0].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[1].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[2].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[3].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[4].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[5].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[6].menu.comidas[0].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
            <tr>
                <th>Almuerzo</th>
                <td><form:select path="dias[0].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[1].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[2].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[3].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[4].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[5].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[6].menu.comidas[1].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
            </tr>
            <tr>
                <th>Comida</th>
                <td><form:select path="dias[0].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[1].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[2].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[3].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[4].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[5].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[6].menu.comidas[2].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
            </tr>
            <tr>
                <th>Merienda</th>
                <td><form:select path="dias[0].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[1].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[2].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[3].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[4].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[5].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[6].menu.comidas[3].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
            </tr>
            <tr>
                <th>Cena</th>
                <td><form:select path="dias[0].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[1].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[2].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[3].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[4].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[5].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
                <td><form:select path="dias[6].menu.comidas[4].id" items="${comidasDisponibles}" itemValue="id" itemLabel="descripcion"/></td>
            </tr>
        </table>
        Descripcion: <form:input path="descripcion"></form:input>
        <button>Guardar</button>
    </form:form>

    <button onclick="window.location.href='/dietista/dietas'">Volver</button>
</body>
</html>