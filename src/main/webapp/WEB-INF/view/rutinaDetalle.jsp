<%@ page import="es.uma.taw24.entity.SesionEjercicioEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.SesionEjercicio" %>
<%@ page import="es.uma.taw24.entity.RutinaEntity" %>
<%@ page import="es.uma.taw24.DTO.Rutina" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rutina Detalle</title>
</head>
<body>

<%
    List<SesionEjercicio> sesionEjercicios = (List<SesionEjercicio>) request.getAttribute("sesionEjercicios");
    Rutina rutina = (Rutina) request.getAttribute("rutina");

%>
<h1>Detalle de Rutina</h1>

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
    </tr>
    </thead>
    <tbody>
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
        <td>
            <form action="/cliente/updateCompletado" method="post">
                <input type="hidden" name="rutinaID" value="<%= rutina.getId() %>">
                <input type="hidden" name="sesionEjercicioId" value="<%= se.getSesion().getId() %>">
                <input type="hidden" name="ejercicioId" value="<%= se.getEjercicio().getId() %>">
                <input type="submit" value="Toggle Completado">
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>


<button onclick="window.location.href='/cliente/entrenamientoCliente'">Volver a entrenamiento</button>

</body>
</html>