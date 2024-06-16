<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.DTO.Dieta" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Integer usuarioId = (Integer) request.getAttribute("usuarioId");
    Dieta dietaActual = (Dieta) request.getAttribute("dietaActual");
%>

<html>
<head>
    <title>Cambio Dieta</title>
</head>
<body>
    <h1>Elige la Nueva Dieta, Actual: <%= dietaActual.getDescripcion() %></h1>

    <form:form method="post" action="/dietista/guardarCambioDieta" modelAttribute="dieta">
        <input type="hidden" name="usuarioId" value="<%= usuarioId %>">
        <form:select path="id" items="${dietas}" itemLabel="descripcion" itemValue="id"/>
        <button>Guardar</button>
    </form:form>

    <button onclick="window.location.href='/dietista/clientesDietista'">Volver</button>
</body>
</html>