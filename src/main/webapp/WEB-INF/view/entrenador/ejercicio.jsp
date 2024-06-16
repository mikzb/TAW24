<%@ page import="es.uma.taw24.DTO.SesionEjercicio" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="java.util.List" %><%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    SesionEjercicio sesionEjercicio = (SesionEjercicio) request.getAttribute("sesionEjercicio");
    List<Ejercicio> ejercicios = (List<Ejercicio>) request.getAttribute("ejercicios");
%>

<html>
<head>
    <title>Añadir nuevo ejercicio</title>
</head>
<body>

<h1>Datos</h1>

<form:form method="post" action="/entrenador/sesion/ejercicio/guardar" modelAttribute="sesionEjercicio">
    <form:hidden path="sesion.id"/>

    <table border="0">
        <tr>
            <%
                if(sesionEjercicio.getEjercicio().getId() == null){
            %>
            <td>Ejercicio:</td>
            <td> <form:select path="ejercicio.id" items="${ejercicios}" itemLabel="nombre" itemValue="id" />
            </td>
            <%
                }else{
            %>
            <form:hidden path="ejercicio.id"/>
            <td>Ejercicio: <%=sesionEjercicio.getEjercicio().getNombre()%></td>
            <%
                }
            %>
        </tr>
        <tr>
            <td>Series:</td>
            <td><form:input path="series" size="4"  maxlength="4" required="true" />
            </td>
        </tr>
        <tr>
            <td>Repeticiones:</td>
            <td><form:input path="repeticiones" size="4"  maxlength="4" required="true" />
            </td>
        </tr>
        <tr>
            <td>Peso:</td>
            <td><form:input path="peso" size="4"  maxlength="4" required="true" />
            </td>
        </tr>
        <tr>
            <td>Completado:</td>
            <td><form:checkbox path="completado" />
            </td>
        </tr>
        <tr>
            <%
                String disabled = ejercicios != null && ejercicios.size() == 0 ? "disabled" : "";
            %>
            <td colspan="2"> <button <%=disabled%>>Enviar</button></td>
        </tr>
    </table>
</form:form>
<br>
<br>
<button onclick="window.location.href='/entrenador/'">Volver al inicio</button>

</body>
</html>
