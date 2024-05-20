<%-- @author: Mikolaj Zabski --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola USUARIO, estoy en dieta</h1>


<h1>Dieta {nombre cliente} {fecha}</h1>

<table border="1">
    <%
        String[][] dieta = (String[][]) request.getAttribute("dieta");
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
</body>
</html>