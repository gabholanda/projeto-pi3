<%-- 
    Document   : erro-nao-autorizado
    Created on : 21/11/2019, 19:24:08
    Author     : marcelo.smoraes2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>ACESSO NEGADO</title>
    </head>
    <body>
        <h1>Nerd Universe</h1>
        <h1>Acesso Negado</h1>
        <form method="post" action="${pageContext.request.contextPath}/infoScreens/home.jsp" novalidate>
                <input type="submit" value="Voltar" class="btn">
            </form>
    </body>
</html>
