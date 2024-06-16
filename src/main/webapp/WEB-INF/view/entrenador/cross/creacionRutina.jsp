<%--<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.RutinaSesion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<RutinaSesion> list = (List<RutinaSesion>) request.getAttribute("listaRutinas");
    Usuario client = (Usuario) request.getAttribute("cliente");
    Integer idRutina = (Integer) request.getAttribute("rutinaId");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creacion de rutina</title>
</head>
<body>
<h1>Inserta sesiones</h1>
<table border="1">
    <tr>
        <th>Lunes</th>
        <th>Martes</th>
        <th>Mi&eacutercoles</th>
        <th>Jueves</th>
        <th>Viernes</th>
        <th>S&aacutebado</th>
        <th>Domingo</th>
    </tr>
    <%
        if(list!=null){
    %>
    <tr>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana() == 1){
            %>
                        <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
                    }else{
            %>
                        <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=1%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana() == 2){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=2%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana() == 3){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=3%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana()==4){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=4%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana() == 5){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=5%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana()==6){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=6%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana()==7){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getSesion()%>?rutinaId=<%=idRutina%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=7%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
    </tr>
    <%
        }else{
    %>
            <tr>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=1%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=2%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=3%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=4%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=5%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=6%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=7%>?rutinaId=<%=idRutina%>">A&ntildeadir Sesi&oacuten</a></th>
            </tr>
    <%
        }
    %>
</table>
</body>
</html>--%>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.RutinaSesion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //Alvaro Acedo Espejo 100%
    List<RutinaSesion> list = (List<RutinaSesion>) request.getAttribute("listaRutinas");
    Usuario client = (Usuario) request.getAttribute("cliente");
    Integer idRutina = (Integer) request.getAttribute("rutinaId");
    Integer sesionId = (Integer) request.getAttribute("sesionId");
    boolean[] diasConSesion = new boolean[8]; // índice 0 no se usa
    for (RutinaSesion rs : list) {
        diasConSesion[rs.getDiadesemana()] = true;
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Creacion de rutina</title>
</head>
<body>
<h1>Inserta sesiones</h1>
<table border="1">
    <tr>
        <th>Lunes</th>
        <th>Martes</th>
        <th>Mi&eacutercoles</th>
        <th>Jueves</th>
        <th>Viernes</th>
        <th>S&aacutebado</th>
        <th>Domingo</th>
    </tr>
    <tr>
        <% for (int dia = 1; dia <= 7; dia++) { %>
        <th>
            <%
                if (diasConSesion[dia]) {
                    for (RutinaSesion rs : list) {
                        if (rs.getDiadesemana() == dia) {
            %>
            <a href="/entrenadorCross/<%= client.getId() %>/crearRutinaSesion/<%= dia %>/listarSesiones?rutinaId=<%= idRutina %>&sesionId=<%=sesionId%>">Editar Sesi&oacuten</a>
            <%
                    }
                }
            } else {
            %>
            <a href="/entrenadorCross/<%= client.getId() %>/crearRutinaSesion/<%= dia %>?rutinaId=<%= idRutina %>">A&ntildeadir Sesi&oacuten</a>
            <%
                }
            %>
        </th>
        <% } %>
    </tr>
</table>
<a href="/entrenadorCross/clientes/<%=client.getId()%>/rutinas">A&ntildeadir Rutina</a></br>
</body>
</html>
