<%@ page import="java.util.List" %>
<%@ page import="es.uma.taw24.entity.*" %>
<%@ page import="es.uma.taw24.DTO.Ejercicio" %>
<%@ page import="es.uma.taw24.DTO.Usuario" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Usuario user = (Usuario) request.getAttribute("cliente");
    List<Ejercicio> listaEj = (List<Ejercicio>) request.getAttribute("ejercicioList");
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
<h1>Elije tu ejercicio</h1>
<%--@elvariable id="sesionEjercicio" type=""--%>
<form:form action="/entrenadorCross/guardar"  method="post" modelAttribute="sesionEjercicio">
    Distancia:<form:input path="distancia"></form:input></br>
    Repeticiones:<form:input path="repeticiones"></form:input></br>
    Duraci&oacuten:<form:input path="duracion"></form:input></br>
    Peso:<form:input path="peso"></form:input></br>
    Velocidad:<form:input path="velocidad"></form:input></br>
    <%--<form:hidden path="completado"></form:hidden>
    <form:hidden path="sesionEjercicio.orden"></form:hidden>--%>
    <form:select path="ejercicio.id" items="${ejercicioList}" itemLabel="nombre" itemValue="id"></form:select></br>
    <input type="submit" value="A&ntilde;adir"/>
</form:form>
</body>
</html>
