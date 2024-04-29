<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dieta {nombre cliente} {fecha}</h1>

<table border="1">
    <%
        String[][] palabras = (String[][]) request.getAttribute("palabras");
        for (String[] fila : palabras) {
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
<form>
    <input type="submit" value="Guardar Datos">
    <input type="submit" value="Importar Datos">
</form>
</body>
</html>