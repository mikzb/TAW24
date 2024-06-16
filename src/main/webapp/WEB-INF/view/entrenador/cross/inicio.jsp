<%--
/**
 * @author Álvaro Acedo Espejo: 100%
 */
--%>

<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Entrenador" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Entrenador trainer = (Entrenador) request.getAttribute("entrenador");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bienvenido</title>
</head>
<body>
<h1>Hola, <%=trainer.getUsuario().getNombre() + " " + trainer.getUsuario().getApellidos()%></h1>
<button onclick="window.location.href='/entrenadorCross/clientes'">Ver Clientes</button>
<%--<button onclick="window.location.href='/entrenadorCross/rutinas'">Ver Rutinas</button>--%>
</body>
</html>
