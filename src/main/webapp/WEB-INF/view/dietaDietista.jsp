<%--
 Pablo Rubia Arias: 100%
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[][] dieta = (String[][]) request.getAttribute("dieta");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Dieta {nombre cliente} {fecha}</h1>

    <table border="1">
        <%
            for (String[] fila : dieta) {
        %>
        <tr>
            <% for (String palabra : fila) { %>
            <td><%= palabra %></td>
            <% } %>
        </tr>
        <%
            }
        %>
    </table>

    <button onclick="window.location.href='/guardarDieta'">Guardar Dieta</button>
    <button onclick="window.location.href='/importarDieta'">Importar Dieta</button>
    <button onclick="window.location.href='/'">Volver</button>
</body>
</html>