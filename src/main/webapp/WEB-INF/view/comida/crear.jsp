<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anadir nueva comida</title>
</head>
<body>
<h2>
    Anadir nueva comida
</h2>
<div style="color: red;">
    ${error}
</div>
<form:form modelAttribute="comida" action="/comida/crear" method="post">
    <table>
        <tr>
            <td>
                <form:hidden path="id" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="descripcion">Descripcion: </form:label>
            </td>
            <td>
                <form:textarea maxlength="150" path="descripcion" />
            </td>
        </tr>
    </table>
    <input type="submit" value="Crear"/>
</form:form>
</body>
</html>