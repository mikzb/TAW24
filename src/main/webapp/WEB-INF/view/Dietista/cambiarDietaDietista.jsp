<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Integer usuarioId = (Integer) request.getAttribute("usuarioId");
%>

<html>
<head>
    <title>CambioDieta</title>
</head>
<body>
    <h1>Elige la Nueva Dieta</h1>

    <form:form method="post" action="/guardarCambioDieta" modelAttribute="dieta">
        <input type="hidden" name="usuarioId" value="<%= usuarioId %>">
        <form:select path="id" items="${dietas}" itemLabel="descripcion" itemValue="id"/>
        <button>Guardar</button>
    </form:form>

    <button onclick="window.location.href='/clientesDietista'">Volver</button>
</body>
</html>