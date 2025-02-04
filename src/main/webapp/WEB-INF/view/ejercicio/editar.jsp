<%@ page import="es.uma.taw24.DTO.GrupoMuscular" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editar ejercicio</title>
</head>
<body>
<h2>
    Editar ejercicio
</h2>
<div style="color: red;">
    ${error}
</div>

<form:form modelAttribute="ejercicio" action="/ejercicio/editar" method="post">
    <table>
        <tr>
            <td><form:hidden path="id" /></td>
        </tr>

        <tr>
            <td><form:label path="tipo">Tipo: </form:label></td>
            <td>
                <form:select path="tipo.id">
                    <form:options items="${tipos}" itemValue="id" itemLabel="nombre"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="nombre">Nombre: </form:label></td>
            <td><form:input maxlength="90" path="nombre" /></td>
        </tr>

        <tr>
            <td><form:label path="url">URL: </form:label></td>
            <td><form:input maxlength="256" path="url" /></td>
        </tr>

        <tr>
            <td>Grupos Musculares:</td>
            <td>
                <%
                    List<GrupoMuscular> gruposmusculares = (List<GrupoMuscular>) request.getAttribute("gruposmusculares");
                    List<GrupoMuscular> gruposmuscularesAsignados = (List<GrupoMuscular>) request.getAttribute("gruposmuscularesAsignados");
                    String checked = "";
                    if (gruposmusculares != null) {
                        for (GrupoMuscular grupo : gruposmusculares) {
                            if (gruposmuscularesAsignados != null && gruposmuscularesAsignados.contains(grupo)) {
                                checked = "checked";
                            } else {
                                checked = "";
                            }
                %>
                <input type="checkbox" name="gruposMuscularesIds" <%= checked %> value="<%= grupo.getId() %>"><%= grupo.getNombre() %><br/>
                <%
                        }
                    }
                %>
            </td>
        </tr>
    </table>
    <input type="submit" value="Editar"/>
</form:form>
<button onclick="window.location.href='/usuario/'">Volver al inicio</button>
</body>
</html>