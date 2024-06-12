<%@ page import="es.uma.taw24.entity.EntrenadorEntity" %>
<%@ page import="es.uma.taw24.entity.UsuarioEntity" %><%--
 Cristian Ruiz Martín : 100%
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UsuarioEntity entrenador = (UsuarioEntity) request.getAttribute("usuario_entrenador");
%>
<h1>Hola, <%=entrenador.getNombre() + " " + entrenador.getApellidos()%>></h1>
<button onclick="window.location.href='/clientesFuerza'">Ver Clientes</button>
<button onclick="window.location.href='/sesiones'">Ver Sesiones</button>
</body>
</html>