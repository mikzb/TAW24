<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Bienvenidos al sistema</h1>

<br>
<%--@elvariable id="usuario" type="es.uma.taw24.DTO.Usuario"--%>
<form:form action="/autenticar" modelAttribute="usuario" method="post">
    <div style="color: red;">
        ${error}
    </div>
    <table>
        <tr>
            <td>Email:</td>
            <td><form:input required="true" path="email" /></td>
        </tr>
        <tr>
            <td>Contraseña:</td>
            <td><form:password required="true" path="password" /></td>
        </tr>
        <tr>
            <td colspan="2"> <form:button> Enviar </form:button></td>
        </tr>
    </table>
</form:form>

<%--temporalmente se puede anadir usuario sin login--%>
<a href="/usuario/crear">Anadir usuario</a>
</body>
</html>
