<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.SesionEjercicio" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Rutina Cliente</title>
</head>
<body>

<%
    List<SesionEjercicio> sesionEjercicios = (List<SesionEjercicio>) request.getAttribute("sesionEjercicios");
%>

<h1>Rutinas del Cliente</h1>

<h2>Tabla de Rutinas</h2>
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
        <td><a href="/entrenador/sesion/editar?idSesion=<%=se.getSesion().getId()%>?idEjercicio=<%=se.getEjercicio().getId()%>">Editar</a></td>
        <td><a href="/entrenador/sesion/borrar?idSesion=<%=se.getSesion().getId()%>?idEjercicio=<%=se.getEjercicio().getId()%>">Borrar</a></td>
    </tr>
    <%
        }
    %>
    </tr>
    </tbody>
</table>

<a href="/entrenador/sesion/<%=sesionEjercicios.getFirst().getSesion().getId()%>/anyadir">Añadir un nuevo ejercicio.</a>

</body>
</html>
