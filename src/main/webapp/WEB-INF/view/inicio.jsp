<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%-- @author: Ignacy Borzestowski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
<% Usuario usuario = (Usuario) request.getAttribute("usuario");
   Boolean crosstraining = (Boolean) request.getAttribute("crosstraining");
%>

<jsp:include page="cabecera.jsp"/>
<table>
    <% if (usuario.isPermisoAdmin()) { %>
    <tr>
        <td>
            <a href="/usuario/">Inicio de administrador</a>
        </td>
    </tr>
    <% } %>
    <% if (usuario.isPermisoCliente()) { %>
    <tr>
        <td>
            <a href="/cliente/">Inicio de cliente</a>
        </td>
    </tr>
    <% } %>
    <% if (usuario.isPermisoEntrenador()) { %>
    <tr>
        <%
        if (crosstraining){
        %>
        <td>
            <a href="/entrenadorCross/">Inicio de entrenador de Cross Training</a>
        </td>
        <%
        }else{
        %>
        <td>
            <a href="/entrenador/">Inicio de entrenador de fuerza</a>
        </td>
        <%
        }
        %>
    </tr>
    <% } %>
    <% if (usuario.isPermisoDietista()) { %>
    <tr>
        <td>
            <a href="/dietista/">Inicio de dietista</a>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>