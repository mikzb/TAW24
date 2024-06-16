<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.SesionEjercicio" %>
<%@ page import="es.uma.taw24.DTO.Rutina" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<SesionEjercicio> list = (List<SesionEjercicio>) request.getAttribute("listSesionEjs");
    Usuario client = (Usuario) request.getAttribute("cliente");
    Integer idRutina = (Integer) request.getAttribute("rutina");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sesion Ejercicio</title>
</head>
<body>
<h1>Sesi&oacuten</h1>
<table border="1">
    <tr>
        <th>Sesi&oacuten</th>
    </tr>
    <%
        if(list!=null){
            for (SesionEjercicio se : list){
    %>
                <tr>
                    <th><%=se.getEjercicio()%></th>
                </tr>
    <%
            }
        }
    %>
</table>
<a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=2%>/crearEjercicio?rutinaId=<%=idRutina%>">A&ntildeadir Ejercicio</a>
</body>
</html>
