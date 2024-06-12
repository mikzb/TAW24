<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.uma.taw24.entity.DietaEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    DietaEntity dieta = (DietaEntity) request.getAttribute("dieta");
%>

<html>
<head>
    <title>dieta <%= dieta.getId() %></title>
</head>
<body>
<h1>Dieta id: <%= dieta.getId() %></h1>

<form:form method="post" action="/dietas/guardarDieta" modelAttribute="DietaEntity">
    <button>Guardar</button>
</form:form>

<button onclick="window.location.href='/dietas'">Volver</button>
</body>
</html>