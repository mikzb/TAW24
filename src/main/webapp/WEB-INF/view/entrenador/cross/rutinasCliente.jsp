<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.DTO.Rutina" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Usuario cliente = (Usuario) request.getAttribute("cliente");
    List<Rutina> lista = (List<Rutina>) request.getAttribute("listaRutinas");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RutinasCliente</title>
</head>
<body>
<h1>Rutinas CrossTraining de <%=cliente.getNombre()%></h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Entrenador</th>
        <th>Fecha de Creaci&oacuten</th>
    </tr>
    <%
        if(!lista.isEmpty()){
        for(Rutina rutina: lista){
    %>
            <tr>
                <th><%=rutina.getId()%></th>
                <th><%=rutina.getIdentrenador().getUsuario().getNombre()%></th>
                <th><%=rutina.getFechacreacion()%></th>
            </tr>
    <%
        }
        }
    %>
</table>
<button onclick="window.location.href='/entrenadorCross/clientes/<%=cliente.getId()%>/rutinas/crear'"
    >A&ntildeadir Rutina</button>
<button onclick="window.location.href='/entrenadorCross/'">Volver</button>
</body>
</html>
