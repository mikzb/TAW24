<%-- @author: Mikolaj Zabski --%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hola USUARIO, estoy en dieta</h1>


<h1>Dieta {nombre cliente} {fecha}</h1>

<%
    String driverName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "mydb";
    String userId = "root";
    String password = "root";

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<table align="center" cellpadding="4" cellspacing="4">
    <tr>

    </tr>
    <tr bgcolor="#008000">
        <td><b>Id</b></td>
        <td><b>ID dietista</b></td>
        <td><b>fechaCreacion</b></td>
    </tr>
    <%
        try {
            connection = DriverManager.getConnection(
                    connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM dieta";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
    %>
    <tr bgcolor="#8FBC8F">

        <td><%=resultSet.getString("id")%></td>
        <td><%=resultSet.getString("idDietista")%></td>
        <td><%=resultSet.getString("fechaCreacion")%></td>


    </tr>

    <%
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>

<%--
<table border="1">
    <%
        String[][] dieta = (String[][]) request.getAttribute("dieta");
        for (String[] comida : dieta) {
    %>
    <tr>
        <% for (String descripcion : comida) { %>
        <td><%= descripcion %></td>
        <% } %>
    </tr>
    <%
        }
    %>
</table>
--%>
</body>
</html>