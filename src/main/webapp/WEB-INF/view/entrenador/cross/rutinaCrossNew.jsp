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
<%--@elvariable id="rutinaSesion" type="es.uma.taw24.DTO.RutinaSesion"--%>
<form:form action="/entrenadorCross/guardar" modelAttribute="rutinaSesion" method="post">
    <%--<form:hidden path="id"></form:hidden>--%>
    <form:hidden path="idrutina"></form:hidden>
    <form:hidden path="idsesion"></form:hidden>
    L:<form:radiobutton path="diadesemana" value="1"/>
    M:<form:radiobutton path="diadesemana" value="2"/>
    X:<form:radiobutton path="diadesemana" value="3"/>
    J:<form:radiobutton path="diadesemana" value="4"/></br>
    V:<form:radiobutton path="diadesemana" value="5"/>
    S:<form:radiobutton path="diadesemana" value="6"/>
    D:<form:radiobutton path="diadesemana" value="7"/>
    <input type="submit" value="A&ntilde;adir"/>
</form:form>
<%--@elvariable id="sesion" type="es.uma.taw24.DTO.Sesion"--%>
<form:form action="/entrenadorCross/guardar" modelAttribute="sesion" method="post">
    <%--<form:hidden path="id"></form:hidden>--%>
    <form:hidden path="crosstraining"></form:hidden>
    <input type="submit" value="A&ntilde;adir Sesion"/>
</form:form>
<%--@elvariable id="sesionEjercicio" type="es.uma.taw24.DTO.SesionEjercicio"--%>
<form:form action="/entrenadorCross/guardar" modelAttribute="sesionEjercicio" method="post">
    <form:hidden path="idejercicio"></form:hidden>
    <%--<form:hidden path="idsesion"></form:hidden>--%>
    Distancia:<form:input path="distancia"></form:input></br>
    Repeticiones:<form:input path="repeticiones"></form:input></br>
    Duraci&oacuten:<form:input path="duracion"></form:input></br>
    Peso:<form:input path="peso"></form:input></br>
    Velocidad:<form:input path="velocidad"></form:input></br>
    <form:hidden path="completado"></form:hidden>
    <form:hidden path="orden"></form:hidden>
    <input type="submit" value="A&ntilde;adir SesionEjercicio"/>
</form:form>
<%--@elvariable id="ejercicio" type="es.uma.taw24.DTO.Ejercicio"--%>
<form:form action="/entrenadorCross/guardar" modelAttribute="ejercicio" method="post">
    <form:select path="id" items="${listaEj}" itemLabel="nombre" itemValue="id"></form:select>
    <input type="submit" value="A&ntilde;adir Ejercicio"/>
</form:form>
</body>
</html>
