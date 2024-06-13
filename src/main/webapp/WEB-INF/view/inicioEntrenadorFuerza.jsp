<%@ page import="es.uma.taw24.entity.EntrenadorEntity" %>
<%@ page import="es.uma.taw24.entity.UsuarioEntity" %><%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    EntrenadorEntity entrenador = (EntrenadorEntity) request.getAttribute("usuario_entrenador");
%>
<h1>Hola, <%=entrenador.getUsuario().getNombre() + " " + entrenador.getUsuario().getApellidos()%></h1>
<button onclick="window.location.href='/clientesFuerza'">Ver Clientes</button>
<button onclick="window.location.href='/sesiones'">Ver Sesiones</button>
</body>
</html>