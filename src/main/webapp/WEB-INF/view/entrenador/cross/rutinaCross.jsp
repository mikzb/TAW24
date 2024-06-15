<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Ejercicio> list = (List<Ejercicio>) request.getAttribute("listaEj");
    Usuario user = (Usuario) request.getAttribute("cliente");
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Rutina</title>
</head>
<body>
<h1>Rutinas CrossTraining de <%=user.getNombre()%></h1>
<%--@elvariable id="rutinaForm" type="es.uma.taw24.DTO.RutinaForm"--%>
<form:form action="/entrenadorCross/guardar"  method="post" modelAttribute="rutinaForm">
    <form:hidden path="rutinaSesion.id" ></form:hidden>
    <form:hidden path="rutinaSesion.idrutina"></form:hidden>
    <form:hidden path="rutinaSesion.idsesion"></form:hidden>
    L:<form:radiobutton path="rutinaSesion.diadesemana" value="1"/>
    M:<form:radiobutton path="rutinaSesion.diadesemana" value="2"/>
    X:<form:radiobutton path="rutinaSesion.diadesemana" value="3"/>
    J:<form:radiobutton path="rutinaSesion.diadesemana" value="4"/></br>
    V:<form:radiobutton path="rutinaSesion.diadesemana" value="5"/>
    S:<form:radiobutton path="rutinaSesion.diadesemana" value="6"/>
    D:<form:radiobutton path="rutinaSesion.diadesemana" value="7"/></br>
<%--@elvariable id="sesion" type="es.uma.taw24.DTO.Sesion"--%>
    <form:hidden path="sesion.id"></form:hidden>
    <form:hidden path="sesion.crosstraining"></form:hidden>
<%--@elvariable id="sesionEjercicio" type="es.uma.taw24.DTO.SesionEjercicio"--%>
    <form:hidden path="sesionEjercicio.idsesion"></form:hidden>
    Distancia:<form:input path="sesionEjercicio.distancia"></form:input></br>
    Repeticiones:<form:input path="sesionEjercicio.repeticiones"></form:input></br>
    Duraci&oacuten:<form:input path="sesionEjercicio.duracion"></form:input></br>
    Peso:<form:input path="sesionEjercicio.peso"></form:input></br>
    Velocidad:<form:input path="sesionEjercicio.velocidad"></form:input></br>
    <form:hidden path="sesionEjercicio.completado"></form:hidden>
    <form:hidden path="sesionEjercicio.orden"></form:hidden>
<%--@elvariable id="ejercicio" type="es.uma.taw24.DTO.Ejercicio"--%>
    <form:select path="ejercicio.id" items="${listaEj}" itemLabel="nombre" itemValue="id"></form:select></br>
    <input type="submit" value="A&ntilde;adir"/>
</form:form>
</body>
</html>
