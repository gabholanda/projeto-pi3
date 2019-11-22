<%-- 
    Document   : LoginJSP
    Created on : Oct 18, 2019, 2:13:26 AM
    Author     : HOLANDAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">

<div class="wrapper fadeInDown lbg-image">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://icon-library.net/images/java-icon-image/java-icon-image-0.jpg" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form>
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="Digite seu login">
            <br><br/>
            <input type="text" id="password" class="fadeIn third" name="login" placeholder="Digite sua senha">
            <br><br/>
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
    </div>
</div>