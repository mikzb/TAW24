<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.DTO.Dieta" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Importar Dieta</title>
</head>
<body>
<h1>Elige Dieta para Importar: </h1>

<form:form method="get" action="/dietista/guardarImportacion" modelAttribute="dieta">
    <form:select path="id" items="${dietas}" itemLabel="descripcion" itemValue="id"/>
    <button>Importar</button>
</form:form>

<button onclick="window.location.href='/dietista/crearDieta?id=0'">Volver</button>
</body>
</html>