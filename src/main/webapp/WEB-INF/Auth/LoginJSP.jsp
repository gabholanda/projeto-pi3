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
 <c:if test="${msgErro != null}">
          <div class="alert alert-danger">
              <c:out value="${msgErro}" />
          </div>
        </c:if>
      <c:if test="${sessionScope.msg != null}">
          <div class="alert alert-success">
              <c:out value="${sessionScope.msg}" />
          </div>
          <c:remove scope="session" var="msg" />
        </c:if>
        <form method="post" action="${pageContext.request.contextPath}/login" novalidate> 
            <input  id="login" class="form-control" name="mail" placeholder="Digite seu e-mail" required>
            <br><br/>
            <input type="password" id="password" class="form-control" name="password" placeholder="Digite sua senha" required>
            <br><br/>
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
    </div>
</div>