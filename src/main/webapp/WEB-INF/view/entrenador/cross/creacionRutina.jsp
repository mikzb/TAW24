<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="es.uma.taw24.DTO.RutinaSesion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<RutinaSesion> list = (List<RutinaSesion>) request.getAttribute("lista");
    Usuario client = (Usuario) request.getAttribute("cliente");
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
                    if(rs.getDiadesemana().equals("1")){
            %>
                        <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
                    }else{
            %>
                        <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=1%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("2")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=2%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("3")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=3%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("4")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=4%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("5")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=5%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("6")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=6%>">A&ntildeadir Sesi&oacuten</a>
            <%
                    }
                }
            %>
        </th>
        <th>
            <%
                for(RutinaSesion rs: list){
                    if(rs.getDiadesemana().equals("7")){
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/editarSesion/<%=rs.getIdsesion()%>">Editar Sesi&oacuten</a>
            <%
            }else{
            %>
            <a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=7%>">A&ntildeadir Sesi&oacuten</a>
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
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=1%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=2%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=3%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=4%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=5%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=6%>">A&ntildeadir Sesi&oacuten</a></th>
                <th><a href="/entrenadorCross/<%=client.getId()%>/crearRutinaSesion/<%=7%>">A&ntildeadir Sesi&oacuten</a></th>
            </tr>
    <%
        }
    %>
</table>
</body>
</html>
