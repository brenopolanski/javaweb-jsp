<%-- 
    Document   : resultado.jsp
    Created on : 30/10/2013, 19:15:14
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String resposta = (String) request.getAttribute("resposta");
        %>


        <p align="center"><%=resposta%> </p>
    </body>
</html>
