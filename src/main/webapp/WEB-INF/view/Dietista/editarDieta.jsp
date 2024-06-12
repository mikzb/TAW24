<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.uma.taw24.entity.Dieta" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Dieta dieta = (Dieta) request.getAttribute("dieta");
%>

<html>
<head>
    <title>dieta <%= dieta.getId() %></title>
</head>
<body>
<h1>Dieta id: <%= dieta.getId() %></h1>

<form:form method="post" action="/dietas/guardarDieta" modelAttribute="Dieta">
    <form:select path=""
    <button>Guardar</button>
</form:form>

<button onclick="window.location.href='/dietas'">Volver</button>
</body>
</html>