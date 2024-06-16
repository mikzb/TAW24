<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.Entrenador" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- @author Ignacy Borzestowski: 100%--%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editar usuario</title>
</head>
<body>
<jsp:include page="../cabecera.jsp"/>

<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<h2> Editar usuario </h2>
<div style="color: red;">
    ${error}
</div>
<form:form modelAttribute="usuario" action="/usuario/editar" method="post">
    <table>
        <tr>
            <td>
                <form:hidden path="id" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">Email: </form:label>
            </td>
            <td>
                <form:input maxlength="90" path="email" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Contrasena: </form:label>
            </td>
            <td>
                <form:password maxlength="90" path="password" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="nombre">Nombre: </form:label>
            </td>
            <td>
                <form:input maxlength="45" path="nombre" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="apellidos">Appelidos: </form:label>
            </td>
            <td>
                <form:input maxlength="90" path="apellidos" />
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
    <input type="submit" value="Editar"/>
</form:form>
<% if (usuario.isPermisoCliente()) { %>
<h2>Entrenadores Asignados</h2>
<table border="1">
    <tr>
        <th>Nombre y apellidos</th>
        <th>Crosstraining</th>
    </tr>
    <% List<Entrenador> entrenadoresAsignados = (List<Entrenador>) request.getAttribute("entrenadoresAsignados");
    if (entrenadoresAsignados!= null) {%>
        <% for (Entrenador entrenador: entrenadoresAsignados) { %>
        <tr>
            <td><%= entrenador.getNombreCompleto() %></td>
            <td><%= entrenador.isCrosstraining() %></td>
            <td><a href="/entrenadorusuario/desasignar?idUsuario=<%= usuario.getId() %>&idEntrenador=<%=entrenador.getId()%>">Desasignar</a></td>
        </tr>
        <% } %>
    <% } %>
</table>


<h2>Asignar Entrenador al Cliente</h2>
<form:form modelAttribute="entrenadorusuario" action="/entrenadorusuario/asignar" method="post">
    <form:hidden path="usuarioId" />
    <form:label path="entrenadorId">Entrenador:</form:label>
    <form:select path="entrenadorId">
        <form:option value="" label="Seleccione un Entrenador"/>
        <form:options items="${entrenadores}" itemValue="id" itemLabel="nombreCompleto"/>
    </form:select>
    <input type="submit" value="Asignar"/>
</form:form>


<h2>Dietista Asignado:
    <% if (usuario.getDietista() != null) { %>
        <%= usuario.getDietista().getNombre() %> <%= usuario.getDietista().getApellidos() %>
    <% } else { %>
        No tiene dietista asignado
    <% } %>
</h2>

<h2>Asignar Dietista al Cliente</h2>
<form:form modelAttribute="usuarioDietistaForm" action="/dietista/asignar" method="post">
    <form:hidden path="usuarioId" />
    <form:label path="dietistaId">Dietista:</form:label>
    <form:select path="dietistaId">
        <form:option value="" label="Seleccione un dietista"/>
        <form:options items="${dietistas}" itemValue="id" itemLabel="nombreCompleto"/>
    </form:select>
    <input type="submit" value="Asignar"/>
</form:form>


<% } %>
</body>
</html>