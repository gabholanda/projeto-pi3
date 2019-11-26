<%-- 
    Document   : LoginJSP
    Created on : Oct 18, 2019, 2:13:26 AM
    Author     : HOLANDAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">

<div class="wrapper fadeInDown lbg-image">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://icon-library.net/images/java-icon-image/java-icon-image-0.jpg" id="icon" alt="User Icon" />
        </div>
        <form method="post" action="${pageContext.request.contextPath}/login" novalidate class="pl-2 pr-2"> 
            <input  id="login" class="form-control" name="mail" placeholder="Digite seu e-mail" required>
            <br><br/>
            <input type="password" id="password" class="form-control" name="password" placeholder="Digite sua senha" required>
            <br><br/>
            <input type="submit" class="fadeIn fourth" value="Log In">
            <c:if test="${msgErro != null}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${msgErro}" />
                </div>
            </c:if>
        </form>
    </div>
</div>