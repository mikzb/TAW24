<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[][] cliente = (String[][]) request.getAttribute("cliente");
%>

<html>
<head>
    <title>clientes</title>
</head>
<body>
    <h1>Tus Clientes</h1>

    <table border="1">
        <%
            for (String[] fila : cliente) {
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

    <button onclick="window.location.href='/'">Volver</button>
</body>
</html>