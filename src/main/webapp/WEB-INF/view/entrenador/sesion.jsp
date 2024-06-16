<%--
/**
 * @author Cristian Ruiz Martín: 100%
 */
--%>

<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.SesionEjercicio" %>
<%@ page import="es.uma.taw24.ui.FiltroSesionEjercicio" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ejercicios</title>
</head>
<body>

<%
    List<SesionEjercicio> sesionEjercicios = (List<SesionEjercicio>) request.getAttribute("sesionEjercicios");
    FiltroSesionEjercicio filtro = (FiltroSesionEjercicio) request.getAttribute("filtro");
%>

<h1>Ejercicios</h1>

<form:form method="post" action="/entrenador/sesion/filtrar" modelAttribute="filtro">
    <form:input path="idSesion" type="hidden" value="<%=filtro.getIdSesion()%>"/>
    Series > <form:input path="series" type="text"/>
    Repeticiones > <form:input path="repeticiones" type="text"/>
    Peso > <form:input path="peso" type="text"/>
    Completado: <form:checkbox path="completado"/>
    <form:button type="submit">Filtrar</form:button>
    <button><a href="/entrenador/sesion?id=<%=filtro.getIdSesion()%>">Limpiar</a></button>
</form:form>

<h2>Tabla de ejercicios</h2>
<table border="1">
    <thead>
    <tr>
        <th>EJERCICIO</th>
        <th>SERIES</th>
        <th>REPETICIONES</th>
        <th>PESO</th>
        <th>URL</th>
        <th>COMPLETADO</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
            <%
            for(SesionEjercicio se : sesionEjercicios){
        %>
    <tr>
        <td><%=se.getEjercicio().getNombre()%></td>
        <td><%=se.getSeries()%></td>
        <td><%=se.getRepeticiones()%></td>
        <td><%=se.getPeso()%></td>
        <td><a href="<%=se.getEjercicio().getUrl()%>">Ver vídeo</a></td>
        <td><%=se.isCompletado()%></td>
        <td><a href="/entrenador/sesion/ejercicio/editar?idSesion=<%=se.getSesion().getId()%>&idEjercicio=<%=se.getEjercicio().getId()%>">Editar</a></td>
        <td><a href="/entrenador/sesion/ejercicio/borrar?idSesion=<%=se.getSesion().getId()%>&idEjercicio=<%=se.getEjercicio().getId()%>">Borrar</a></td>
    </tr>
    <%
        }
    %>
    </tr>
    </tbody>
</table>

<a href="/entrenador/sesion/<%=filtro.getIdSesion()%>/ejercicio/anyadir">Añadir un nuevo ejercicio.</a>

</body>
</html>
