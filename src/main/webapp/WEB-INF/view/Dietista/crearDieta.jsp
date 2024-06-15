<%--
 Pablo Rubia Arias: 100%
--%>

<%@ page import="es.uma.taw24.DTO.Dieta" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Dieta dietaActual = (Dieta) request.getAttribute("dietaActual");
%>

<html>
<head>
    <title>Crear Dieta</title>
</head>
<body>
<h1>Crear Dieta</h1>
<form:form method="post" action="/dietista/guardarCreacionDieta" modelAttribute="dietaNueva">
    <input type="hidden" name="dietaId" value="<%= dietaActual.getId() %>">
    Descripcion: <form:input path="descripcion" value="<%=dietaActual.getDescripcion()%>"></form:input>
    <table border="1">
        <tr>
            <th></th>
            <th>Lunes</th>
            <th>Martes</th>
            <th>Miercoles</th>
            <th>Jueves</th>
            <th>Viernes</th>
            <th>Sábado</th>
            <th>Domingo</th>
        </tr>
        <tr>
            <th>Desayuno</th>
            <td>
                <form:select path="dias[0].menu.comidas[0].id">
                    <form:options items="${comidas1}" itemValue="id" itemLabel="descripcion" title="hola" />
                </form:select>
            </td>
            <td>
                <form:select path="dias[1].menu.comidas[0].id">
                    <form:options items="${comidas6}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[2].menu.comidas[0].id">
                    <form:options items="${comidas11}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[3].menu.comidas[0].id">
                    <form:options items="${comidas16}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[4].menu.comidas[0].id">
                    <form:options items="${comidas21}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[5].menu.comidas[0].id">
                    <form:options items="${comidas26}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[6].menu.comidas[0].id">
                    <form:options items="${comidas31}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
        <tr/>
        <tr>
            <th>Almuerzo</th>
            <td>
                <form:select path="dias[0].menu.comidas[1].id">
                    <form:options items="${comidas2}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[1].menu.comidas[1].id">
                    <form:options items="${comidas7}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[2].menu.comidas[1].id">
                    <form:options items="${comidas12}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[3].menu.comidas[1].id">
                    <form:options items="${comidas17}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[4].menu.comidas[1].id">
                    <form:options items="${comidas22}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[5].menu.comidas[1].id">
                    <form:options items="${comidas27}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[6].menu.comidas[1].id">
                    <form:options items="${comidas32}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Comida</th>
            <td>
                <form:select path="dias[0].menu.comidas[2].id">
                    <form:options items="${comidas3}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[1].menu.comidas[2].id">
                    <form:options items="${comidas8}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[2].menu.comidas[2].id">
                    <form:options items="${comidas13}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[3].menu.comidas[2].id">
                    <form:options items="${comidas18}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[4].menu.comidas[2].id">
                    <form:options items="${comidas23}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[5].menu.comidas[2].id">
                    <form:options items="${comidas28}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[6].menu.comidas[2].id">
                    <form:options items="${comidas33}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Merienda</th>
            <td>
                <form:select path="dias[0].menu.comidas[3].id">
                    <form:options items="${comidas4}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[1].menu.comidas[3].id">
                    <form:options items="${comidas9}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[2].menu.comidas[3].id">
                    <form:options items="${comidas14}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[3].menu.comidas[3].id">
                    <form:options items="${comidas19}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[4].menu.comidas[3].id">
                    <form:options items="${comidas24}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[5].menu.comidas[3].id">
                    <form:options items="${comidas29}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[6].menu.comidas[3].id">
                    <form:options items="${comidas34}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Cena</th>
            <td>
                <form:select path="dias[0].menu.comidas[4].id">
                    <form:options items="${comidas5}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[1].menu.comidas[4].id">
                    <form:options items="${comidas10}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[2].menu.comidas[4].id">
                    <form:options items="${comidas15}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[3].menu.comidas[4].id">
                    <form:options items="${comidas20}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[4].menu.comidas[4].id">
                    <form:options items="${comidas25}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[5].menu.comidas[4].id">
                    <form:options items="${comidas30}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
            <td>
                <form:select path="dias[6].menu.comidas[4].id">
                    <form:options items="${comidas35}" itemValue="id" itemLabel="descripcion"/>
                </form:select>
            </td>
        </tr>
    </table>
    <button>Guardar</button>
</form:form>

    <button onclick="window.location.href='/dietista/importarDieta'">Importar</button>
    <button onclick="window.location.href='/dietista/dietas'">Volver</button>
</body>
</html>