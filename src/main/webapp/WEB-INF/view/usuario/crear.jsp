<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anadir nuevo usuario</title>
</head>
<body>
<h2>
    Anadir nuevo usuario
</h2>
    <div style="color: red;">
            ${error}
    </div>
<form:form modelAttribute="usuario" action="/usuario/guardar" method="post">
    <table>
        <tr>
            <td>
                <form:label path="email">Email: </form:label>
            </td>
            <td>
                <form:input path="email" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Contrasena: </form:label>
            </td>
            <td>
                <form:input path="password" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="nombre">Nombre: </form:label>
            </td>
            <td>
                <form:input path="nombre" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="apellidos">Appelidos: </form:label>
            </td>
            <td>
                <form:input path="apellidos" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="edad">Edad: </form:label>
            </td>
            <td>
                <form:input path="edad" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sexo">Sexo: </form:label>
            </td>
            <td>
                <form:select path="sexo">
                    <form:option value="H">Hombre</form:option>
                    <form:option value="M">Mujer</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:checkbox path="permisoAdmin"/>
                <form:label path="permisoAdmin">Admin </form:label>
            </td>
        </tr>
        <tr>
            <td>
                <form:checkbox path="permisoCliente"/>
                <form:label path="permisoCliente">Cliente </form:label>
            </td>
        </tr>
        <tr>
            <td>
                <form:checkbox path="permisoDietista"/>
                <form:label path="permisoDietista">Dietista </form:label>
            </td>
        </tr>
        <tr>
            <td>
                <form:checkbox path="permisoEntrenador"/>
                <form:label path="permisoEntrenador">Entrenador </form:label>
                <form:select path="crosstraining">
                    <form:option value="0">Fuerza</form:option>
                    <form:option value="1">Crosstraining</form:option>
                </form:select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Anadir"/>
</form:form>
</body>
</html>