<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="es.uma.taw24.DTO.Entrenador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Entrenador entrenador = (Entrenador) request.getAttribute("entrenador");
%>
<h1>Hola, <%=entrenador.getUsuario().getNombre() + " " + entrenador.getUsuario().getApellidos()%></h1>
<button onclick="window.location.href='/entrenador/clientes'">Ver Clientes</button>
<button onclick="window.location.href='/entrenador/rutinas'">Ver Rutinas</button>
</body>
</html>