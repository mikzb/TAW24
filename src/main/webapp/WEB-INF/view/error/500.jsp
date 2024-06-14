<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- @author Ignacy Borzestowski: 100%--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error interno del servidor</title>
</head>
<body>
<h2>Error interno del servidor</h2>
<p>Ha pasado algo mal: </p>
<%
    Exception exception = (Exception) request.getAttribute("exception");
   if (exception != null) {
%>
<p><%= exception.getMessage() %></p>
<%   } %>
<a href="/">Ir al inicio</a>
</body>
</html>