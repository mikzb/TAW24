<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="es.uma.taw24.entity.ComidaEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ComidaEntity[] comidasDieta = (ComidaEntity[]) request.getAttribute("comidasDieta");
%>

<html>
<head>
    <title>Crear Dieta</title>
</head>
<body>
<h1>Crear Nueva Dieta</h1>
    <form:form method="post" action="/guardarDieta" modelAttribute="comidasDieta">
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
                <form:select path="comidasDieta[${index}].id" itemValue="id" itemLabel="descripcion" items="${comidas}" />
            <tr>
                <th>Almuerzo</th>
            </tr>
            <tr>
                <th>Comida</th>
            </tr>
            <tr>
                <th>Merienda</th>
            </tr>
            <tr>
                <th>Cena</th>
            </tr>
        </table>
        <button>Guardar</button>
    </form:form>

    <button onclick="window.location.href='/dietas'">Volver</button>
</body>
</html>