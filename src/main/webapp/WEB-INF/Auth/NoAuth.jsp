<%-- 
    Document   : NoAuthJSP
    Created on : 18/11/2019, 19:35:22
    Author     : marcelo.smoraes2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso Negado</title>
    </head>
    <body>
        <h1>Acesso não autorizado!</h1>
        <h2>Clique em Voltar</h2>
        <a href="${pageContext.request.contextPath}/home">Voltar</a>
    </body>
</html>
